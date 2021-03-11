package LaboratoriskiVezbi.vezba1.zadaca1;

import java.util.Scanner;

public class PraznicnoPatuvanje extends Patuvanje{
    private int pocD;
    private int pocM;
    private int krajD;
    private int krajM;

    public PraznicnoPatuvanje() {
        super ();
    }

    public PraznicnoPatuvanje(String imeAgencija, int cena,
                              int pocD, int pocM, int krajD, int krajM) throws Exception {
        super (imeAgencija, cena);
        if((pocM == krajM && pocD > krajD) || pocM > krajM) {
            this.pocM = krajM;
            this.krajM = pocM;
            this.pocD = krajD;
            this.krajD = pocD;

            throw new Exception (imeAgencija, cena, pocD, pocM, krajD, krajM);
        }
        this.pocD = pocD;
        this.pocM = pocM;
        this.krajD = krajD;
        this.krajM = krajM;
    }

    public int getPocD() {
        return pocD;
    }

    public int getPocM() {
        return pocM;
    }

    public int getKrajD() {
        return krajD;
    }

    public int getKrajM() {
        return krajM;
    }

    public int vratiVremeVoDenovi(){
        if(krajM == pocM) return krajD - pocD;
        else {
            return (krajM - pocM) * 30 - Math.abs (pocD - krajD);
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            PraznicnoPatuvanje pp =
                    new PraznicnoPatuvanje ("Transbalkan", 6000, 6, 1, 5, 1);
            System.out.println (pp.vratiVremeVoDenovi ());
        }
        catch (Exception exception){
            System.out.println ("Exception");
            PraznicnoPatuvanje temp = new PraznicnoPatuvanje (exception.getImeAgencija (),
                    exception.getCena (), exception.getPocD (), exception.getPocM (),
                    exception.getKrajD (), exception.getKrajM ());
        }

        Scanner str = new Scanner (System.in);
        String s = str.nextLine ();
        System.out.println (s);
    }

}
