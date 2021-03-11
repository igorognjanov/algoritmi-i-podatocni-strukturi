package AuditoriskiVezbi.aud02.SLLPolinom;

public class Node {
    protected Integer koeficient;
    protected Integer eksponent;
    protected Node succ;

    public Node(int koeficient, int eksponent, Node succ){
        this.koeficient = koeficient;
        this.eksponent = eksponent;
        this.succ = succ;
    }

    @Override
    public String toString(){
        return this.koeficient.toString () + "x^" + this.eksponent.toString ();
    }

}
