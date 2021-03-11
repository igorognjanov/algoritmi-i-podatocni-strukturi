package AuditoriskiVezbi.aud02.SLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

class SLLJL<E extends Comparable<E>> {


    public SLL<E> joinLists(SLL<E> list1, SLL<E> list2){
        SLL<E> result = new SLL<> ();
        SLLNode<E> node1 = list1.getFirst ();
        SLLNode<E> node2 = list2.getFirst ();

        while(node1 != null && node2 != null){
            if((node1.element.compareTo (node2.element)) < 0){
                result.insertLast (node1.element);
                node1 = node1.succ;
            }
            else if(node1.element.compareTo (node2.element) == 0){
                list1.delete (node1);
                list2.delete (node2);
                result.insertLast (node1.element);
                node1 = node1.succ;
                node2 = node2.succ;
            }
            else{
                result.insertLast (node2.element);
                node2 = node2.succ;
            }
        }
        while (node1 != null){
            result.insertLast (node1.element);
            node1 = node1.succ;
        }
        while (node2 != null){
            result.insertLast (node2.element);
            node2 = node2.succ;
        }
        return result;
    }

    public static void main(String[] args) throws IOException, IOException {
        SLL<Integer> lista1 = new SLL<> ();
        SLL<Integer> lista2 = new SLL<> ();
        SLL<Integer> spoeni = new SLL<> ();


        BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
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
        lista1.deleteDuplicates ();
        lista2.deleteDuplicates ();
        SLLJL<Integer> q = new SLLJL<> ();
        spoeni = q.joinLists(lista1, lista2);
        Iterator<Integer> it = spoeni.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
            if(it.hasNext())
                System.out.print(" ");
        }
        System.out.println();
    }
}
