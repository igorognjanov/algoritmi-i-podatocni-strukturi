package AuditoriskiVezbi.aud04.Knapsaclk;

public class KnapsackProblem {
    public static int getMaxProfit(int[] p, int[] w, int C){
        int mat[][] = new int[p.length+1][C+1];
        for(int i=0; i<p.length+1; i++){
            mat[i][0] = 0;
        }
        for(int i=0; i<C+1; i++){
            mat[0][i] = 0;
        }
        for(int i=1; i<=p.length; i++){
            for(int j=1; j<=C; j++){
                if(w[i-1] <= j)
                    mat[i][j] = Math.max (p[i-1] + mat[i-1][j-w[i-1]], mat[i-1][j]);
                else
                    mat[i][j] = mat[i-1][j];
            }
        }
        for(int i=0; i<=p.length; i++){
            for(int j=0; j<=C; j++){
                System.out.print (mat[i][j]);
            }
            System.out.println ();
        }
        return mat[p.length][C];
    }

    public static int DPKnapsack(int t[], int p[], int C) {
        int i, j;
        int n = t.length;
        int D[][] = new int[n + 1][C + 1];
        for (j = 0; j <= C; j++) {
            D[0][j] = 0;
        }
        for (i = 1; i <= n; i++) {
            D[i][0] = 0;
        }
        for (i = 1; i <= n; i++)
            for (j = 1; j <= C; j++)
                if (t[i - 1] <= j)
                    D[i][j] = Math.max(p[i-1] + D[i-1][j - t[i-1]], D[i-1][j]);
                else
                    D[i][j] = D[i - 1][j];


                for(i=0; i<n+1; i++){
                    for(j=0; j<C+1; j++){
                        System.out.print (D[i][j]+ "\t");
                    }
                    System.out.println ();
                }
        return D[n][C];
    }


    public static void main(String[] args) {
        int[] p = {10, 20, 30};
        int[] w = {60, 100, 120};
        int C = 0;
        System.out.println (getMaxProfit (p, w, C));
    }

}
