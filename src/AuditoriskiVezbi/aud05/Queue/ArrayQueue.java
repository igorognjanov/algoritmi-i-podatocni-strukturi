package AuditoriskiVezbi.aud05.Queue;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {
    private E[] elements;
    private int size, front, rear;

    public ArrayQueue(int n){
        size = 0;
        elements = (E[]) new Object [n];
        front = rear = 0;
    }

    public boolean isEmpty(){
        return 0 == size;
    }

    public int size(){
        return size;
    }

    public E peek(){
        if(elements.length == 0) throw new NoSuchElementException ();
        return elements[front];
    }

    public void clear(){
        rear = front = 0;
        size = 0;
        //for(int i=0; i<elements.length; i++) elements[i] = null;
    }

    public void enqueue(E e){
        if(elements.length == size) return;//redicata e polna
        elements[rear++] = e;
        if(rear == elements.length) rear = 0;
        size++;
    }

    public E dequeue(){
        if(size == 0) throw new NoSuchElementException ();
        E temp = elements[front];
        elements[front] = null;
        front++;
        if (front == elements.length) front = 0;
        size--;
        return temp;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<> (20);
        for(int i=0; i<15; i++) queue.enqueue (i);
        for(int i=0; i<15; i++) System.out.println (queue.dequeue ());
        System.out.println (queue.isEmpty ());
        queue.enqueue (200);
        System.out.println (queue.isEmpty ());
        queue.clear ();
        System.out.println (queue.isEmpty ());
    }
}
