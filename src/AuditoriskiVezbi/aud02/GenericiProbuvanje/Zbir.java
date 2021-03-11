package AuditoriskiVezbi.aud02.GenericiProbuvanje;

public class Zbir<E> {
    private E var1;
    private E var2;

    Zbir(Object v1, Object v2){
        this.var1 = (E) v1;
        this.var2 = (E) v2;
    }



    public static void main(String[] args) {
        Zbir z1 = new Zbir (2, 8);
        Zbir z2 = new Zbir ("Igor", "Ognjanov");
        Zbir z3 = new Zbir (5.55, 1.14);
    }
}
