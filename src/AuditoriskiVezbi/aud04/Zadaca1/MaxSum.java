package AuditoriskiVezbi.aud04.Zadaca1;

import java.util.Scanner;

public class MaxSum {

    private static int[][] getMax(int[][] mat, int m, int n){
        int[][] newMat = new int[m][n];
        newMat[0][0] = mat[0][0];
        for(int i=1; i<m; i++)
            newMat[i][0] = newMat[i-1][0] + mat[i][0];
        for(int j=1; j<n; j++)
            newMat[0][j] = newMat[0][j-1] + mat[0][j];

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                newMat[i][j] = mat[i][j] + Math.max (newMat[i-1][j], newMat[i][j-1]);
            }
        }

        return newMat;
    }

    public static void main(String[] args) {
        int[][] mat;
        int m, n;
        Scanner input = new Scanner (System.in);
        m = input.nextInt ();
        n = input.nextInt ();

        mat = new int[m][n];
        for(int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                mat[i][j] = input.nextInt ();
            }
        }
        System.out.println ();
        for(int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                System.out.print (mat[i][j] + "\t");
            }
            System.out.println ();
        }
        System.out.println ();

        int[][] mat2 = getMax (mat, m, n);
        for(int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                System.out.print (mat2[i][j] + "\t");
            }
            System.out.println ();
        }
    }
}
