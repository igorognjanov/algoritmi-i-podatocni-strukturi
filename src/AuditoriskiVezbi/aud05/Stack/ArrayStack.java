package AuditoriskiVezbi.aud05.Stack;

import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E>{
    private E[] elements;
    private int depth;

    public ArrayStack(int n){
        elements = (E[]) new Object[n];
        depth = 0;
    }

    public boolean isEmpty(){
        return  depth == 0;
    }

    public E peek(){
        if(isEmpty ())
            throw new NoSuchElementException ();
        return elements[depth-1];
    }

    public void clear(){
        for(int i=0; i<depth; i++) elements[i] = null;
        depth = 0;
    }

    public int size(){
        return depth;
    }

    public void push(E e){
        elements[depth++] = e;
    }

    public E pop(){
        if(depth == 0) throw new NoSuchElementException ();
        E temp = elements[--depth];
        elements[depth] = null;
        return temp;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<> (10);
        System.out.println(stack.isEmpty ());
        for(int i=0; i<10; i++) stack.push (i);
        System.out.println (stack.peek ());
        System.out.println (stack.pop());
        while (!stack.isEmpty ())System.out.println (stack.pop ());
    }
}

