package AuditoriskiVezbi.aud03.Zadaca3;

import java.util.Scanner;

public class Coins {

    public static NumberOfCoins minCoins(int n){
        int min = Integer.MAX_VALUE;
        int temp = 0;
        NumberOfCoins num = new NumberOfCoins ();
        for(int i1=0; i1<=(n/50); i1++){
            for(int i2=0; i2<=(n/10); i2++){
                for(int i3=0; i3<=(n/5); i3++){
                    for(int i4=0; i4<=(n/2); i4++){
                        for(int i5=0; i5<=n; i5++){
                            temp = i1*50 + i2*10 + i3* 5 + i4*2 + i5;
                            if(temp == n){
                                if(i1 + i2 + i3 + i4 + i5 < min) {
                                    min = i1 + i2 + i3 + i4 + i5;
                                    num = new NumberOfCoins (i1, i2, i3, i4, i5, min);
                                }
                                temp = 0;
                            }
                        }
                    }
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int n = input.nextInt ();
      //  System.out.println (minCoins (n).getNumOf50 () + " " + minCoins (n).getNumOf10 ()+ " " + minCoins (n).getNumOf5 ()
      //          + " " +               minCoins (n).getNumOf2 ()+ " " +  minCoins (n).getNumOf1 ()+ " " +  minCoins (n).getRez ());
        System.out.println (minCoins (n));
    }

}
