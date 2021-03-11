package FB.Lista;

import LaboratoriskiVezbi.vezba2.zadaca2.SLL;
import LaboratoriskiVezbi.vezba2.zadaca2.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lista {

    public static void print(SLL<Integer> lista){
        SLLNode<Integer> temp = lista.getFirst ();
        while (temp != null){
            System.out.println (temp.getElement ());
            temp = temp.getSucc ();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int N = Integer.parseInt (br.readLine ());
        SLL<Integer> lista = new SLL<> ();

        for(int i=0; i<N; i++){
            lista.insertLast (Integer.parseInt (br.readLine ()));
        }

        int m = Integer.parseInt (br.readLine ());
        int n = Integer.parseInt (br.readLine ());

        lista.mirror (m, n);

        print(lista);
    }
}
