package AuditoriskiVezbi.aud03.Zadaca3;

import java.util.Scanner;

public class CoinsGreedy {

    public static int getCoins(int[] coins, int n, int[] usedCoins){

        int sum = 0;
        int tmp = n;
        while(tmp > 0){
            for(int i=coins.length-1; i>=0; i--){
                while(tmp/coins[i] >= 1) {
                    tmp -= coins[i];
                    sum++;
                    usedCoins[i]++;
                }
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int n = input.nextInt ();
        int[] coins = {1, 2, 5, 10, 50};
        int[] usedCoins = {0, 0, 0, 0, 0};
        System.out.println (getCoins (coins, n, usedCoins));
        for(int i=0; i<usedCoins.length; i++){
            System.out.println (usedCoins[i]);
        }
    }
}
