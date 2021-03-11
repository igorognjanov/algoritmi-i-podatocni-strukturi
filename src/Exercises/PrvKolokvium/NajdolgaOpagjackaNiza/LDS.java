package Exercises.PrvKolokvium.NajdolgaOpagjackaNiza;

import java.util.Scanner;


public class LDS {


    private static int najdolgaOpagackaSekvenca(int[] a) {

        // Vasiot kod tuka
        int max = 1;
        for(int i=0; i<a.length; i++){
            int iCounter = 1;
            for(int j=i; j<a.length; j++){
                int pred  = j;
                int jCounter = 1;
                for(int k=j; k<a.length; k++){
                    if(a[pred] > a[k]) {
                        pred = k;
                        jCounter++;
                    }
                }
                if(jCounter > iCounter) iCounter = jCounter;
            }
            if(iCounter > max) max = iCounter;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = stdin.nextInt();
        }
        System.out.println(najdolgaOpagackaSekvenca(a));
    }


}
