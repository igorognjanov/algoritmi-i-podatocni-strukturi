package AuditoriskiVezbi.aud03.Zadaca3;

public class NumberOfCoins {
    private int numOf50;
    private int numOf10;
    private int numOf5;
    private int numOf2;
    private int numOf1;
    private int rez;

    public NumberOfCoins(int numOf50, int numOf10, int numOf5, int numOf2, int numOf1, int rez) {
        this.numOf50 = numOf50;
        this.numOf10 = numOf10;
        this.numOf5 = numOf5;
        this.numOf2 = numOf2;
        this.numOf1 = numOf1;
        this.rez = rez;
    }

    public NumberOfCoins() {
    }

    public void setNumOf50(int numOf50) {
        this.numOf50 = numOf50;
    }

    public void setNumOf10(int numOf10) {
        this.numOf10 = numOf10;
    }

    public void setNumOf5(int numOf5) {
        this.numOf5 = numOf5;
    }

    public void setNumOf2(int numOf2) {
        this.numOf2 = numOf2;
    }

    public void setNumOf1(int numOf1) {
        this.numOf1 = numOf1;
    }

    public void setRez(int rez) {
        this.rez = rez;
    }

    public int getNumOf50() {
        return numOf50;
    }

    public int getNumOf10() {
        return numOf10;
    }

    public int getNumOf5() {
        return numOf5;
    }

    public int getNumOf2() {
        return numOf2;
    }

    public int getNumOf1() {
        return numOf1;
    }

    public int getRez() {
        return rez;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder ();
        str.append ("Broj na 50: ");
        str.append (numOf50);
        str.append ("\n");
        str.append ("Broj na 10: ");
        str.append (numOf10);
        str.append ("\n");
        str.append ("Broj na 5: ");
        str.append (numOf5);
        str.append ("\n");
        str.append ("Broj na 2: ");
        str.append (numOf2);
        str.append ("\n");
        str.append ("Broj na 1: ");
        str.append (numOf1);
        str.append ("\n");
        str.append ("Broj na moneti: ");
        str.append (rez);
        str.append ("\n");
        return str.toString ();
    }
}
