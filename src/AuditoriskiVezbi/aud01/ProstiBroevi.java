package AuditoriskiVezbi.aud01;

import java.util.Scanner;

public class ProstiBroevi {
/*
    public static boolean isPrime(int n){
        if(n == 1 || n == 2 || n == 3) return true;
        if(n%2 == 0) return false;
        for(int i=3; i<n/2 + 1; i -= -1){
            if(n%i == 0)
                return false;
        }
        return true;
    }
*/
    public static boolean isPrime(int n, int m){
        if(n == 1) return true;
        if(n == 4) return false;
        if(m == 2) return true;
        if(n % m == 0)return false;
        return isPrime(n, m-1);
}

    public static void main(String[] args) {
        int i;
        int count = 0;
        for(i = 1; i <= 100; i++) {
            if (isPrime(i, i / 2 + 1)) {
                count += i;
            }
        }
        System.out.println(count);
}
}
