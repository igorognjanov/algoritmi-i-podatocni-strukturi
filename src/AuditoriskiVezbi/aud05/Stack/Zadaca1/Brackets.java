package AuditoriskiVezbi.aud05.Stack.Zadaca1;

import AuditoriskiVezbi.aud05.Stack.ArrayStack;
import AuditoriskiVezbi.aud05.Stack.LinkedStack;

import java.util.NoSuchElementException;

public class Brackets {
    public static boolean checkIfValid(String str){
        LinkedStack<Character> stack = new LinkedStack<> ();
        for(int i=0; i<str.length (); i++){
            try {
                char c = str.charAt (i);
                if(c == '(' || c == '{' || c == '[') stack.push (c);
                else if (c == ')' || c == ']' || c == '}') {
                    char left = stack.pop ();
                    if(!checkIfCorresponding(left, c))
                        return false;
                }
            }
            catch (NoSuchElementException n){
                return false;
            }
        }
        if(stack.isEmpty ()) return true;
        return false;
    }

    public static boolean checkIfCorresponding(char left, char right){
        if((left == '{' && right == '}') ||
                (left == '[' && right == ']') ||
                (left == '(' && right == ')'))
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "{[1+2]+(3+[4-5)]}";
        System.out.println (checkIfValid (s));
    }
}
