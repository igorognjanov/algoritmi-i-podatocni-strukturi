package AuditoriskiVezbi.aud02.DLL;

public class Node<E> {
    private E element;
    protected Node<E> pred;
    protected Node<E> succ;

    public Node(E element, Node<E> pred, Node<E> succ){
        this.element = element;
        this.pred = pred;
        this.succ = succ;
    }

    @Override
    public String toString(){
        return element.toString ();
    }
}
