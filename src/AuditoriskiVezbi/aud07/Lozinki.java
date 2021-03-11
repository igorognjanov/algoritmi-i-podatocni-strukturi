package AuditoriskiVezbi.aud07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Lozinki {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        CBHT<String, String> users = new CBHT<>(N * 2);


        for(int i=1;i<=N;i++){
            String imelozinka = br.readLine();
            String[] pom = imelozinka.split(" ");
            users.insert(pom[0], pom[1]);
        }

        while(true){
            String line = br.readLine();
            if(line.trim().equals("KRAJ")) break;
            String[] parts = line.split(" ");
            String username = parts[0];
            String password = parts[1];

            if(users.search(username) == null)
                System.out.println("Nenajaven");

            else if(users.search(username).element.element.equals(password)) {
                System.out.println("Najaven");
                break;
            }
            else System.out.println("Nenajaven");
        }

    }
}