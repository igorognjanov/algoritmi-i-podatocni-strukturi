package AuditoriskiVezbi.aud03.Zadaca6;

public class Stepen {
    private static double stepen(int x, int stepen){
        if(stepen == 0) return 1;
        if(stepen % 2 == 0){
            return stepen(x, stepen/2) * stepen(x, stepen/2);
        }
            return stepen(x, stepen/2) * stepen(x, stepen/2) * x;
    }



    private static int[][] paskalovTriagolnik(int n){
        int[][] mat = new int[n][n];
        for(int i=0; i<n; i++){
            mat[i][0] = 1;
        }
        for(int i=0; i<n; i++){
            mat[i][i] = 1;
        }
        for(int i=1; i<n; i++){
            for(int j=1; j<i; j++){
                mat[i][j] = mat[i-1][j-1] + mat[i-1][j];
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = paskalovTriagolnik(10);
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                System.out.print (mat[i][j] + "\t");
            }
            System.out.println ();
        }

        //System.out.println (Stepen (4, 2));
    }
}
