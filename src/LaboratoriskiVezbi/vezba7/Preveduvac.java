package LaboratoriskiVezbi.vezba7;



import AuditoriskiVezbi.aud07.OBHT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



class Preveduvac{
    public static void main(String[] as) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        OBHT<String, String> dictionary = new OBHT<> (N + N);

        for(int i=0; i<N; i++){
            String line = bf.readLine();
            String[] parts = line.split(" ");
            String eng = parts[1];
            String mkd = parts[0];

            dictionary.insert(eng, mkd);
        }

        while (true){
            String line = bf.readLine();
            if(line.equals("Kraj")) break;
            if(dictionary.search(line) == -1){
                System.out.println("/");
            }
            else
                System.out.println(dictionary.buckets[dictionary.search(line)].element);

        }

    }
}