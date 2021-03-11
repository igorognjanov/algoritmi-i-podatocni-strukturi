package ProbenKolokvium;

import java.util.Iterator;
import java.util.Scanner;

/*Дадена е двојно поврзана листа со N јазли каде секој јазел содржи по еден карактер (буква).
        Да се провери дали двојно поврзаната листа е
        палиндром: односно ако ја изминете од почеток до крај и од крај до почеток, дали
        ќе добиете ист збор. Во првиот ред од влезот даден е бројот на јазли
        во листата N, а во вториот ред се дадени броевите. На излез треба да
        се испечати 1 ако листата е палиндром, -1 ако не е.*/


public class PalindromDLL {

    public static int isItPalindrome(DLL<Integer> list){
        // vasiot kod tuka
        Integer[] niza = new Integer[list.length ()];
        Iterator<Integer> iterator = list.iterator ();
        int i=0;
        while(iterator.hasNext ()){
            niza[i] = iterator.next ();
            i++;
        }
        Integer[] niza2 = new Integer [list.length ()];
        int k=0;
        for(int j=i-1; j>=0; j--){
            niza2[k] = niza[j];
            k++;
        }
        for(int l=0; l<list.length (); l++){
            System.out.println ("niza1: " + niza[l] + "   niza2: " + niza2[l]);
            //if(!(niza[l].equals (niza2[l])))
            //    return -1;
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(in.nextInt());
        }
        in.close();
        System.out.println(isItPalindrome(list));
    }

}