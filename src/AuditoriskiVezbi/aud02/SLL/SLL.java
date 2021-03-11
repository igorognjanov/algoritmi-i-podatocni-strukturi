package AuditoriskiVezbi.aud02.SLL;

import java.util.Iterator;
import java.util.NoSuchElementException;

class SLL<E extends Comparable<E>> {
    protected SLLNode<E> first;

    public SLL(){
        this.first = null;
    }

    public int length(){
        if(first == null) return 0;
        int n=1;
        SLLNode<E> temp = first;
        while(temp.succ != null){
            temp = temp.succ;
            n++;
        }
        return n;
    }

    @Override
    public String toString() {
        if(this.first.succ == null) return "Prazna lista";
        String str = first.element.toString ();
        SLLNode<E> temp = first.succ;
        while(temp != null){
            str += " -> ";
            str += temp.element.toString ();
            temp = temp.succ;
        }
        return str;
    }

    public void insertFirst(E New){
        SLLNode<E> temp = new SLLNode<> (New, first);
        first = temp;
    }

    public void insertAfter(E New, SLLNode<E> ins){
        //if(ins == null) return;
        SLLNode<E> temp = new SLLNode<> (New, ins.succ);
        ins.succ = temp;
    }

    public void insertBefore(E New, SLLNode<E> ins){
        SLLNode<E> temp = first;
        if(temp == null) System.out.println ("Listata e prazna!");;
        if(temp == ins) this.insertFirst (New);
        while(temp.succ != ins){
            temp = temp.succ;
        }
        if(temp.succ == ins) {
            SLLNode<E> newNode;
            newNode = new SLLNode<> (New, ins);
            temp.succ = newNode;
        }
        else{
            System.out.println ("Ne postoi elementot vo listata!");
        }
    }

    public void insertLast(E New){
        if(first == null){
            this.insertFirst(New);
            return;
        }
        SLLNode<E> tmp = first;
        while (tmp.succ != null){
            tmp = tmp.succ;
        }
        SLLNode<E> last = new SLLNode<> (New, null);
        tmp.succ = last;
    }

    public E deleteFirst(){
        if(first == null) {
            System.out.println ("Listata e prazna!");
            return null;
        }
        E temp = first.element;
        first = first.succ;
        return temp;
    }

    public void delete(SLLNode<E> o){
        SLLNode<E> temp = first;
        if(first == o) {
            deleteFirst ();
            return;
        }
        if(first == null) {
            System.out.println ("Listata e prazna");
            return;
        }
        while (temp.succ != o && temp.succ.succ != null){
            temp = temp.succ;
        }
        if(temp.succ == o)
            temp.succ = temp.succ.succ;
        else System.out.println ("Elementot ne postoi vo listata");
    }

    public SLLNode<E> getFirst(){ return first;}

    public Iterator<E> iterator () {
// vraka iterator koj gi posetuva site elementi na listata od levo na desno
        return new LRIterator<E>();
    }
    // //////////Inner class ////////////
    private class LRIterator<E> implements Iterator<E> {
        private SLLNode<E> place, prev, curr;
        private LRIterator() {
            place = (SLLNode<E>) first;
            curr = prev = null;
        }
        public boolean hasNext() {
            return (place != null);
        }
        public E next() {
            if (place == null)
                throw new NoSuchElementException ();
            E nextElem = place.element;
            prev = curr;
            curr = place;
            place = place.succ;
            return nextElem;
        }
        public void remove() {
//Not implemented
        }
    }

    public void deleteDuplicates(){
        if(first == null) return;
        if(first.succ == null) return;
        SLLNode<E> temp = first;
        while(temp.succ != null){
            if(temp.element.compareTo (temp.succ.element) == 0){
                this.delete (temp);
            }
            temp = temp.succ;
        }
    }



}
