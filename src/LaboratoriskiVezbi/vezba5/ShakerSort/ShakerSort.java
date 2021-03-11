package LaboratoriskiVezbi.vezba5.ShakerSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ShakerSort {

    static void shakerSort(int a[], int n) {
        int i;
        boolean flipped;
        for(i=0; i<n; i++){
            flipped = false;
            for(int j=n-1-i; j>i; j--){
                if(a[j] < a[j-1]){
                    flipped = true;
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
            printArray (a);

            for(int j=0; j<n-i-1; j++){
                if(a[j] > a[j+1]){
                    flipped = true;
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }

            printArray (a);

            if(!flipped) break;
        }

    }

    public static void printArray(int [] a){
        for (int j : a) {
            System.out.print (j + " ");
        }
        System.out.println ();
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
        shakerSort(a,n);
    }
}