package AuditoriskiVezbi.aud02.DLL;

public class DLL<E> {
    private Node<E> first;
    private Node<E> last;

    public DLL() {
        this.first = null;
        this.last = null;
    }

    public void insertFirst(E o){
        Node<E> temp = new Node<> (o, null, first);
        if(first == null)
            last = temp;
        else
            first.pred = temp;
        first = temp;
    }

    public void insertLast(E o){
        if(first == null){
            insertFirst (o);
            return;
        }
        Node<E> ins = new Node<> (o, last, null);
        last.succ = ins;
        last = ins;
    }

    public void deleteLast(){
        last.pred.succ = null;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder ();
        Node<E> temp = first;
        while(temp != null){
            str.append (temp.toString ());
            str.append ('\t');
            temp = temp.succ;
        }
        return str.toString ();
    }

    public static void main(String[] args) {
        DLL<Integer> list = new DLL<> ();
        list.insertFirst (10);
        list.insertFirst (100);
        list.insertFirst (200);
        list.insertLast (300);
        list.deleteLast ();
        System.out.println (list);
    }

}
