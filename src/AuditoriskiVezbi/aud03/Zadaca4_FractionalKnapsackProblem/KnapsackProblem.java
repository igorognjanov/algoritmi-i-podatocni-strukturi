package AuditoriskiVezbi.aud03.Zadaca4_FractionalKnapsackProblem;

class FractionalKnapsackProblem {

    public static double fractionalKnapsack(int[] p, int[]w, double c, int n){



        for(int i=0; i<n-1; i++){
            for (int j=0; j<n-i-1; j++){
                if((double) p[j] / (double) w[j] < (double)p[j+1] / (double)w[j+1]){
                    int temp = p[j];
                    p[j] = p[j+1];
                    p[j+1] = temp;
                    temp = w[j+1];
                    w[j+1] = w[j];
                    w[j] = temp;
                }
            }
        }
        double profit = 0;

        for(int i=0; i<n; i++){
            if(c >= w[i]){
                profit += p[i];
                c -= w[i];
            }
            else{
                profit += (c / (double) w[i]) * p[i];
                c = 0;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] profit = {10, 20, 30, 40};
        int[] tezini = {8, 7, 10, 14};
        double kapacitet = 20;
        System.out.println (fractionalKnapsack (profit, tezini, kapacitet, 4));
    }
}
