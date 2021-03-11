package LaboratoriskiVezbi.vezba2.zadaca2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpecialSLLJoin<E extends Comparable<E>> {


    public SLL<E> specialJoin(SLL<E> lista1, SLL<E> lista2){
        SLL<E> result = new SLL<> ();

        SLLNode<E> node1 = lista1.getFirst ();
        SLLNode<E> node2 = lista2.getFirst ();

        while (node1 != null && node2 != null && node1.succ != null && node2.succ != null){
            result.insertLast (node1.element);
            result.insertLast (node1.succ.element);
            result.insertLast (node2.element);
            result.insertLast (node2.succ.element);
            node1 = node1.succ.succ;
            node2 = node2.succ.succ;
        }
        while(node1 != null){
            result.insertLast (node1.element);
            node1 = node1.succ;
        }

        while (node2 != null){
            result.insertLast (node2.element);
            node2 = node2.succ;
        }
        return result;
    }



    public static void main(String[] args) throws IOException {

        SLL<Integer> lista1 = new SLL<> ();
        SLL<Integer> lista2 = new SLL<> ();


        BufferedReader stdin = new BufferedReader (new InputStreamReader (
                System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista1.insertLast(Integer.parseInt(pomniza[i]));
        }

        s = stdin.readLine();
        N = Integer.parseInt(s);
        s = stdin.readLine();
        pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista2.insertLast(Integer.parseInt(pomniza[i]));
        }

        SpecialSLLJoin<Integer> temp = new SpecialSLLJoin<> ();

        SLL<Integer> spoeni = temp.specialJoin(lista1,lista2);
        System.out.println (spoeni);

    }
}
