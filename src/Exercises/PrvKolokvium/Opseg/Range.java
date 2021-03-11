package Exercises.PrvKolokvium.Opseg;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Range {

    static long proveri(long N, long A, long B) {
        // Vasiot kod tuka
        for(;A<=B; A++){
            if(A*A + S (A) + 200*A == N) return A;
        }
        return -1;
    }

    public static long S(long n){
        if(n==0) return 0;
        return n%10 + S(n/10);
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long res = proveri(N, A, B);
        System.out.println(res);

        br.close();

    }

}
