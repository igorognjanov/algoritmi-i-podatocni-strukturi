import AuditoriskiVezbi.aud07.CBHT;
import LaboratoriskiVezbi.vezba2.zadaca2.SLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rodendeni {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

        int N = Integer.parseInt (br.readLine ());


        CBHT<String, SLL<String>> tabela = new CBHT<> (N + N);

        String line;
        String [] parts;
        String ime;
        String [] data;
        String den;
        String mesec;
        String rodenden;

        SLL<Integer> list = new SLL<> ();


        for(int i=0; i<N; i++){
            line = br.readLine ();
            parts = line.split (" ");
            ime = parts[0] + " " + parts[1];
            data = parts[2].split ("/");
            den = data[0];
            mesec = data[1];
            rodenden = den + "/" + mesec;

            if(tabela.search (rodenden) == null){
                tabela.insert (rodenden, new SLL<> ());
            }
            tabela.search (rodenden).element.element.insertLast (ime);
        }

        data = br.readLine ().split ("/");
        rodenden = data[0] + "/" + data[1];

        if(tabela.search (rodenden) !=  null)
        System.out.println (tabela.search (rodenden).element.element);
    }
}
