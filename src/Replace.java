import LaboratoriskiVezbi.vezba2.zadaca2.SLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Replace {
    public static void main(String[] args) throws IOException {
        SLL<Integer> lista = new SLL<> ();
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

        int N = Integer.parseInt (br.readLine ());

        for(int i=0; i<N; i++){
            lista.insertLast (Integer.parseInt (br.readLine ()));
        }

        int x = Integer.parseInt (br.readLine ());

        System.out.println (lista.getPosition (x));
        System.out.println (lista);
    }
}
