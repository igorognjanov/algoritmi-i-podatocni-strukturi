package LaboratoriskiVezbi.vezba5.NeparnoParnoSortiranje;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddEvenSort {

    static void oddEvenSort(int a[], int n) {
        // Vasiot kod tuka
        int key;
        int begin = 0;
        int end = a.length - 1;
        int i;

        for (int index = begin + 1; index <= end; index++) {
            key = a[index];
            i = index - 1;
            if(a[index] % 2 == 1) {
                while (i >= begin && ((a[i] > key && a[i] % 2 == 1) || a[i] % 2 == 0)) {

                    a[i + 1] = a[i];
                    i = i - 1;
                }
                a[i + 1] = key;
            }
        }
        for (int index = end - 1; index >= begin; index--) {
            key = a[index];
            i = index + 1;
            if(a[index] % 2 == 0) {
                while (i <= end && ((a[i] > key && a[i] % 2 == 0) || a[i] % 2 == 1)) {

                    a[i - 1] = a[i];
                    i = i + 1;
                }
                a[i - 1] = key;
            }
        }
    }


    public static void main(String[] args) throws IOException{
        int i;
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String [] pom = s.split(" ");
        int [] a = new int[n];
        for(i=0;i<n;i++)
            a[i]=Integer.parseInt(pom[i]);
        oddEvenSort(a,n);
        for(i=0;i<n-1;i++)
            System.out.print(a[i]+" ");
        System.out.print(a[i]);
    }
}