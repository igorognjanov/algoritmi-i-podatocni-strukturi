package AuditoriskiVezbi.aud05.Stack;

public interface Stack<E> {

    void push(E e);

    E pop();

    E peek();

    boolean isEmpty();

    void clear();
}
