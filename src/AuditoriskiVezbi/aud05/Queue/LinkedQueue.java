package AuditoriskiVezbi.aud05.Queue;

import AuditoriskiVezbi.aud05.Stack.LinkedStack;

import java.util.NoSuchElementException;

class SLLNode<E>{
    public E element;
    public SLLNode<E> succ;

    public SLLNode(E element, SLLNode<E> succ){
        this.element = element;
        this.succ = succ;
    }
}

public class LinkedQueue<E> implements Queue<E> {
    private SLLNode<E> front, rear;
    private int size;

    public LinkedQueue(){
        front = rear = null;
        size = 0;
    }

    public void clear() {
        front = rear = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public E peek(){
        if(front == null) throw new NoSuchElementException ();
        return front.element;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(E e){
        SLLNode<E> temp = new SLLNode<> (e, null);
        if(rear == null){
            rear = temp;
            front = rear;
            return;
        }
        rear.succ = temp;
        rear = temp;
        size++;
    }

    public E dequeue() {
        if(front == null) throw new NoSuchElementException ();
        E temp = front.element;
        front = front.succ;
        if(front == null) rear = null;
        size--;
        return temp;
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<> ();
        /*for(int i=0; i<20; i++){
            queue.enqueue (i);
        }
        for(int i=0; i<20; i++){
            System.out.println (queue.dequeue ());
        }*/
        queue.enqueue (10);
        System.out.println (queue.dequeue ());
        System.out.println (queue.dequeue ());
        //System.out.println (queue.dequeue ());
    }
}
