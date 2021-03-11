package LaboratoriskiVezbi.vezba3.Zadaca2_ZigZagSequence;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZigZagSequence {

    static int najdiNajdolgaCikCak(int a[]) {
        // Vasiot kod tuka
        int max=0;
        int count = 1;
        int i=1;
        while(i <= a.length-1) {
            if ((a[i - 1] > 0 && a[i] < 0) || (a[i - 1] < 0 && a[i] > 0)) {
                count++;
            } else {
                if (count > max)
                    max = count;
                count = 1;
            }
            if (i == a.length - 1) {
                if (count > max) {
                    max = count;
                }
            }
            i++;
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int a[] = new int[N];
        for (i=0;i<N;i++)
            a[i] = Integer.parseInt(br.readLine());

        int rez = najdiNajdolgaCikCak(a);
        System.out.println(rez);

        br.close();

    }

}
