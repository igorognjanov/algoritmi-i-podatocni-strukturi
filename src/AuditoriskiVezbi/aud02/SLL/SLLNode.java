package AuditoriskiVezbi.aud02.SLL;

class SLLNode<E> {
    public E element;
    public SLLNode<E> succ;

    public SLLNode(E element, SLLNode<E> succ){
        this.element = element;
        this.succ = succ;
    }

    @Override
    public String toString(){
        return element.toString ();
    }

}
