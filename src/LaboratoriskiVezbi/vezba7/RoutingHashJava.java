package LaboratoriskiVezbi.vezba7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

class RoutingTable{
    private ArrayList<String> networks;

    public RoutingTable(){
        networks = new ArrayList<> ();
    }

    public void addLine(String line){
        String[] parts = line.split (",");
        for (int i=0; i<parts.length; i++){
            this.add (parts[i]);
        }
        networks.addAll (Arrays.asList (parts));
    }

    private void add(String network){
        networks.add (getFirst24Bits (network));
    }

    private String getFirst24Bits(String network){
        String newNet = "";
        String[] parts = network.split ("\\.");
        for(int i=0; i<parts.length-1; i++){
            newNet += parts[i] + ".";
        }
        return newNet;
    }

    public boolean contains(String net){
        return networks.contains (getFirst24Bits (net));
    }

}


public class RoutingHashJava{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader (new InputStreamReader (System.in));
        int N = Integer.parseInt (bf.readLine ());
        Hashtable<String, RoutingTable> hashtable = new Hashtable<> (N*2);

        for(int i=0; i<N; i++){
            String Interface = bf.readLine ();
            RoutingTable table = new RoutingTable ();
            table.addLine (bf.readLine ());
            hashtable.put (Interface, table);
        }

        int M = Integer.parseInt (bf.readLine ());
        for(int i=0; i<M; i++){
            String Interface = bf.readLine ();
            String network = bf.readLine ();
            if(!hashtable.containsKey (Interface))
                System.out.println ("ne postoi");
            else if(hashtable.get (Interface).contains (network))
                System.out.println ("postoi");
            else{
                System.out.println ("ne postoi");
            }
        }

        bf.close ();
    }
}
