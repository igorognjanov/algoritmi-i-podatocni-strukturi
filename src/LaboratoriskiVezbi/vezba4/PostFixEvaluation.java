package LaboratoriskiVezbi.vezba4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Stack;

public class PostFixEvaluation {

    public static int presmetaj(char [] niza){
        Stack<Integer> stack = new Stack<Integer> ();
        String red = new String (niza);
        //System.out.println (red);
        String[] numbers = red.split (" ");
        for(int i=0; i<numbers.length; i++){
            if(numbers[i].charAt (0) == '+'){
                int a = stack.pop();
                int b = stack.pop();
                stack.push (b + a);
            }
            else if(numbers[i].charAt (0) == '-'){
                int a = stack.pop();
                int b = stack.pop();
                stack.push (b - a);
            }
            else if(numbers[i].charAt (0) == '*'){
                int a = stack.pop();
                int b = stack.pop();
                stack.push (b * a);
            }
            else if(numbers[i].charAt (0) == '/'){
                int a = stack.pop();
                int b = stack.pop();
                stack.push (b / a);
            }
            else {
                stack.push (Integer.parseInt (numbers[i]));
            }
        }
        return stack.pop ();
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();
        System.out.println (presmetaj (exp));

        br.close();

    }

}
