package AuditoriskiVezbi.aud02.SLL;

public class Monom implements Comparable<Monom> {
    protected Integer koeficient;
    protected Integer eksponent;

    public Monom(int koeficient, int eksponent){
        this.eksponent = eksponent;
        this.koeficient = koeficient;
    }

    public Monom soberi(Monom m){
        return new Monom(this.koeficient + m.koeficient, this.eksponent);
    }

    @Override
    public int compareTo(Monom m){
        if(this.eksponent == m.eksponent) return 0;
        if(this.eksponent < m.eksponent) return -1;
        if(this.eksponent > m.eksponent) return 1;
        return 0;
    }

    @Override
    public String toString(){
        return koeficient.toString () + "x^" + eksponent.toString ();
    }
}
