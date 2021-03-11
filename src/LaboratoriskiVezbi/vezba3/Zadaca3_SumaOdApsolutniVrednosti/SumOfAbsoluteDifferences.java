package LaboratoriskiVezbi.vezba3.Zadaca3_SumaOdApsolutniVrednosti;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SumOfAbsoluteDifferences {

    static int solve(int numbers[], int N, int K) {
        // vasiot kod ovde
        // mozete da napisete i drugi funkcii dokolku vi se potrebni
        int counter = 2;
        int j, i;
        int [][] maxabs = new int[K+1][N];

        while(counter <= K){
            for(j = counter -1 ; j < N; j++){
                for(i = 0; i < j; i++ ){
                    int abs = Math.abs(numbers[i] - numbers[j]) + maxabs[counter -1][i];
                    if(abs > maxabs[counter][j]) {
                        maxabs[counter][j] = abs;
                    }
                }
            }
            counter ++;
        }
        int max = 0;
        for(i = 0; i < N; i++){
            if(maxabs[K][i] > max)
                max = maxabs[K][i];
        }

        return max;

    }

    public static int getZbirOdAbsolutniSumi(int [] niza){
        int zbir=0;
        for(int i=0; i<niza.length-1; i++){
            zbir += Math.abs (niza[i+1] - niza[i]);
        }
        return zbir;
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int numbers[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (i=0;i<N;i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int res = solve(numbers, N, K);
        System.out.println ();
        System.out.println(res);

        br.close();

    }

}