package LaboratoriskiVezbi.vezba6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Lozinki {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=1;i<=N;i++){
            String imelozinka = br.readLine();
            String[] pom = imelozinka.split(" ");
        }

    }
}
