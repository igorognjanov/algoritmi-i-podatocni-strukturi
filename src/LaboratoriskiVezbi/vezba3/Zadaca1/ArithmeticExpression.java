package LaboratoriskiVezbi.vezba3.Zadaca1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArithmeticExpression {

    // funkcija za presmetuvanje na izrazot pocnuvajki
    // od indeks l, zavrsuvajki vo indeks r
    static int presmetaj(char c[], int l, int r) {
        // Vasiot kod tuka
        System.out.println ("START");

        if(l+4 == r){
            if(c[l+2] == '+')
                return Integer.parseInt (String.valueOf (c[l+1])) + Integer.parseInt (String.valueOf (c[l+3]));
            return Integer.parseInt (String.valueOf (c[l+1])) - Integer.parseInt (String.valueOf (c[l+3]));
        }

        int middle=-1;
        int temp = l+1;
        boolean flag = true;
        int zagradi=0;

        while(temp < r){
            if(c[temp] == '('){
                zagradi++;
            }
            if(c[temp] == ')'){
                zagradi--;
                if(zagradi == 0){
                    middle = temp+1;
                    break;
                }
            }
            temp++;
        }
        //System.out.println (middle);
        System.out.println (c[middle]);
        if(c[middle] == '+')
            return presmetaj (c, l+1, middle-1) + presmetaj (c, middle+1, r-1);
        return presmetaj (c, l+1, middle-1) - presmetaj (c, middle+1, r-1);
     //   return 10;
    }


    public static void main(String[] args) throws Exception {
       // int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        int rez = presmetaj(exp, 0, exp.length-1);
        System.out.println(rez);

        br.close();

    }

}
