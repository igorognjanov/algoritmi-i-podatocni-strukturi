package AuditoriskiVezbi.aud08;

public class BNode<E> {
    public E element;
    public BNode<E> left;
    public BNode<E> right;

    static final int LEFT = 1;
    static final int RIGHT = 2;


    public BNode(E element){
        this.element = element;
        left = right = null;
    }

    public BNode(E element, BNode<E> left, BNode<E> right){
        this.left = left;
        this.right = right;
        this.element = element;
    }
}
