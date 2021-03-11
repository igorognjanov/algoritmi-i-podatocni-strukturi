package AuditoriskiVezbi.aud04.Zadaca2;

public class AvionskiKarti {

    private static int getMinValue(int[][] cost, int n, int[] tax){
        int[] niza = new int[n];
        niza[0] = tax[0];
        for(int i=1; i<n; i++){
            niza[i] = Integer.MAX_VALUE;
            for(int j=0; j<i; j++){
                niza[i] = Math.min (niza[i], niza[j] + cost[j][i] + tax[j]);
            }
        }
        return niza[n-1];
    }

    public static void main(String[] args) {
        int[] tax = {100, 200, 300, 100};
        int n = 4;
        int[][] cost = {{150, 340, 670, 400},
                {340, 560, 780, 900},
                {233, 344, 566, 778},
                {111, 222, 333, 444},
        };
        System.out.println (getMinValue (cost, n, tax));
    }
}
