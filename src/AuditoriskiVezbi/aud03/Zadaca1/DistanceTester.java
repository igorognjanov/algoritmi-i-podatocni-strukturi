package AuditoriskiVezbi.aud03.Zadaca1;

import java.nio.channels.Pipe;
import java.util.Scanner;

public class DistanceTester {
    public static double calculateDistance(Point a, Point b){
        return Math.sqrt(Math.pow (a.getX () - b.getX (), 2) + Math.pow (a.getY () - b.getY (), 2));
    }


    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int n = input.nextInt ();
        Point [] niza = new Point[n];
        for(int i=0; i<n; i++){
            niza[i] = new Point (input.nextDouble (), input.nextDouble ());
        }
        double max = -1;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(calculateDistance (niza[i], niza[j]) > max)
                    max = calculateDistance (niza[i], niza[j]);
            }
        }
        System.out.println (max);
    }
}
