package LaboratoriskiVezbi.vezba1.zadaca1;

public class Exception extends Throwable {
    private String imeAgencija;
    private int cena;
    private int pocD;
    private int pocM;
    private int krajD;
    private int krajM;

    public Exception(String imeAgencija, int cena,
                     int pocD, int pocM, int krajD, int krajM) {
        this.imeAgencija = imeAgencija;
        this.cena = cena;
        this.pocD = krajD;
        this.pocM = krajM;
        this.krajD = pocD;
        this.krajM = pocM;
    }

    public String getImeAgencija() {
        return imeAgencija;
    }

    public int getCena() {
        return cena;
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
}
