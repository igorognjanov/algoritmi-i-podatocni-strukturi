package AuditoriskiVezbi.aud05.Stack;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedStack<E> {
    private SLLNode<E> top;
    private int size;

    public LinkedStack(){
        top = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void push(E e){
        top = new SLLNode<> (e, top);
        size++;
    }

    public void clear(){
        top = null;
        size = 0;
    }

    public E peek(){
        if(size == 0) throw new NoSuchElementException ();
        return top.getElement ();
    }

    public E pop(){
        if(size == 0) throw new NoSuchElementException ();
        E temp = top.getElement ();
        top = top.getSucc ();
        size--;
        return temp;
    }

    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<> ();
        System.out.println (stack.size());
        for(int i=0; i<20; i++) stack.push (i);
        for(int i=0; i<20; i++) System.out.println (stack);
    }

}
