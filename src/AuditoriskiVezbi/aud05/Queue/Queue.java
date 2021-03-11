package AuditoriskiVezbi.aud05.Queue;

public interface Queue<E> {

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    void clear();

    E peek();

    int size();
}
