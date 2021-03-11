package LaboratoriskiVezbi.vezba2.zadaca2;


import java.util.Iterator;

public class SLL<E extends Comparable<E>> {
    SLLNode<E> first;

    public SLL(){
        first = null;
    }

    public void setFirst(E n){
        if(first == null) {
            first = new SLLNode<> (n, null);
            return;
        }
        SLLNode<E> temp = new SLLNode<> (n, first);
        first = temp;
    }

    @Override
    public String toString(){
        if(first == null) return "Listata e prazna!";
        String str = "";
        SLLNode<E> temp = first;
        while (temp.succ != null){
            str += temp.element.toString ();
            temp = temp.succ;
            str += "    ";
        }
        str += temp.element.toString ();
        return str;
    }

    public void insertLast(E n){
        if(first == null){
            setFirst (n);
            return;
        }
        SLLNode<E> temp = first;
        while (temp.succ != null){
            temp = temp.succ;
        }
        SLLNode<E> last = new SLLNode<> (n, null);
        temp.succ = last;
    }

    public void insertSorted(E n){
        if(first == null){
            setFirst (n);
            return;
        }

        SLLNode<E> temp = first;
        while (temp.succ != null && temp.succ.element.compareTo(n) < 0){
            temp = temp.succ;
        }
        SLLNode<E> newnode = null;
        if(temp.succ != null)
            newnode = new SLLNode<> (n, temp.succ.succ);
        temp.succ = newnode;
    }

    public int getPosition(E x){
        SLLNode<E> temp = first;
        int pos = -1;
        int counter = 1;
        while (temp != null){
            if(temp.element.equals (x))
                pos = counter;
            counter++;
            temp = temp.succ;
        }
        if(pos != -1 && pos != 1){
            temp = first;
            SLLNode<E> last = first;
            counter = 1;
            while (temp != null){
                if(counter == pos){
                    if(temp.succ == null){
                        last.succ = null;
                        temp = temp.succ;
                    }
                    else {
                        last.succ = temp.succ;
                        temp = temp.succ;
                    }
                }
                else{
                    last = temp;
                    temp = temp.succ;
                }
                counter++;
            }
            setFirst (x);
        }
        return pos;
    }


    public void mirror(int m, int n){
        if(first != null){
            SLLNode<E> predm = first;
            SLLNode<E> M = first;
            SLLNode<E> N = first;
            int counter = 1;
            while (M != null && counter != m){
                M = M.succ;
                counter ++;
            }
            counter = 1;
            while (N != null && counter != n){
                N = N.succ;
                counter ++;
            }
            counter = 1;
            while (predm != null && counter != m-1){
                predm = predm.succ;
                counter ++;
            }

            SLLNode<E> tmp = M;
            SLLNode<E> newsucc = N.succ;
            SLLNode<E> next;

            while(tmp != N && tmp != null){
                next = tmp.succ;
                tmp.succ = newsucc;
                newsucc = tmp;
                tmp = next;
            }
            tmp.succ = newsucc;
            predm.succ = tmp;
        }
    }


    public SLLNode<E> getFirst(){
        return first;
    }

    public Iterator<E> iterator(){
        return new LRIterator<E> ();
    }

    public void replace(){
        SLLNode<E> temp = first;
        SLLNode<E> last = first;
        while (temp.succ != null){
            last = temp;
            temp = temp.succ;
        }
        last.succ = first;
        temp.succ = first.succ;
        first.succ = null;
        first = temp;
    }

    private class LRIterator<E> implements Iterator<E> {
        private SLLNode<E> prev;
        private SLLNode<E> place;
        private SLLNode<E> curr;

        public LRIterator(){
            place = (SLLNode<E>) first;
            prev = null;
            curr = null;
        }

        @Override
        public boolean hasNext(){
            return place != null;
        }

        @Override
        public E next(){
            if(first != null){
                E nextElement = place.element;
                prev = curr;
                curr = place;
                place = place.succ;
                return nextElement;
            }
            return null;
        }
    }
}
