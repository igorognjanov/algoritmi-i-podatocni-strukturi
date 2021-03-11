package AuditoriskiVezbi.aud05.Stack;

public class SLLNode<E> {
    private E element;
    private SLLNode<E> succ;

    public E getElement() {
        return element;
    }

    public SLLNode<E> getSucc() {
        return succ;
    }

    public SLLNode(E element, SLLNode<E> succ){
        this.element = element;
        this.succ = succ;
    }



    @Override
    public String toString(){
        return element.toString ();
    }
}
