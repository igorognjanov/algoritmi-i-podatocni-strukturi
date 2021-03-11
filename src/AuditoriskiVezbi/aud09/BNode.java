package AuditoriskiVezbi.aud09;

public class BNode <E extends Comparable<E>>{

    E element;

    BNode<E> left;
    BNode<E> right;

    public BNode(E elem){
        this.element = elem;
        this.left = this.right = null;
    }

    public BNode(E elem, BNode<E> right, BNode<E> left){
        this.element = elem;
        this.right = right;
        this.left = left;
    }
}
