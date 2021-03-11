package LaboratoriskiVezbi.vezba4;

import AuditoriskiVezbi.aud05.Stack.SLLNode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

class LinkedStack<E>{
    private int size;
    private SLLNode<E> top;

    public LinkedStack(){
        size = 0;
        top = null;
    }

    public boolean isEmpty(){
        return 0 == size;
    }

    public void push(E e){
        top = new SLLNode<> (e, top);
        size++;
    }

    public E pop(){
        if(isEmpty ()) throw new NoSuchElementException ();
        E temp = top.getElement ();
        top = top.getSucc ();
        size--;
        return temp;
    }
}


public class CheckXML {
    public static String getClosingTag(String str){
        String ret = "[/";
        ret += str.substring (1);
        return ret;
    }

    public static boolean isTag(String s){
        return s.charAt (0) == '[' && s.charAt (s.length ()-1) == ']';
    }

    public static boolean isValid(String left, String right){
        return getClosingTag (left).equals (right);
    }

    public static boolean isClosingTag(String s){
        return s.charAt (1) == '/';
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String [] redovi = new String[n];

        for(int i=0;i<n;i++)
            redovi[i] = br.readLine();

        int valid=1;

        // Vasiot kod tuka
        // Moze da koristite dopolnitelni funkcii ako vi se potrebni
        LinkedStack<String> stack = new LinkedStack<> ();
        for (int i=0; i<n; i++){
            redovi[i] = redovi[i].trim ();
            if(isTag (redovi[i])){
                if(!isClosingTag (redovi[i])){
                    stack.push (redovi[i]);
                }
                else{
                    try{
                        String left = stack.pop ();
                        if(!isValid (left, redovi[i])) {
                            valid = 0;
                            break;
                        }
                    }
                    catch (NoSuchElementException e){
                        valid = 0;
                    }
                }
            }
        }
        if(!stack.isEmpty ())
            valid = 0;

        System.out.println(valid);

        br.close();
    }
}