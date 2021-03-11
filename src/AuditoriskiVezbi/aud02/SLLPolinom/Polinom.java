package AuditoriskiVezbi.aud02.SLLPolinom;

public class Polinom {
    private Node first;

    public Polinom() {
        first = null;
    }

    public Node getFirst(){
        return first;
    }

    void insertLast(int koeficient, int eksponent) {
        if (first == null) {
            first = new Node (koeficient, eksponent, null);
            return;
        }
        Node temp = first;
        while (temp.succ != null) {
            temp = temp.succ;
        }
        Node last = new Node (koeficient, eksponent, null);
        temp.succ = last;
    }

    @Override
    public String toString(){
        if(first == null) return "Listata e prazna!";
        String str = "";
        Node temp = first;
        while(temp != null){
            str += temp.toString ();
            str += "  ";
            temp = temp.succ;
        }
        return str;
    }

    public static void main(String[] args) {
        Polinom polinom = new Polinom ();
        polinom.insertLast (10, 2);
        polinom.insertLast (5, 1);
        polinom.insertLast (3, 0);
        System.out.println (polinom);
    }
}
