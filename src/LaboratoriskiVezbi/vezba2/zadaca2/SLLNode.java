package LaboratoriskiVezbi.vezba2.zadaca2;

public class SLLNode<E> {
    E element;
    SLLNode<E> succ;

    public SLLNode(E element, SLLNode succ){
        this.element = element;
        this.succ = succ;
    }

    public E getElement() {
        return element;
    }

    public SLLNode<E> getSucc() {
        return succ;
    }

    @Override
    public String toString(){
        return element.toString ();
    }
}
