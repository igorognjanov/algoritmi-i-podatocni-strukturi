package LaboratoriskiVezbi.vezba1.zadaca1;

public class Patuvanje {
    private String imeAgencija;
    private int cena;

    public Patuvanje() {
    }

    public Patuvanje(String imeAgencija, int cena) {
        this.imeAgencija = imeAgencija;
        this.cena = cena;
    }

    public String getImeAgencija() {
        return imeAgencija;
    }

    public int getCena() {
        return cena;
    }

    public void setImeAgencija(String imeAgencija) {
        this.imeAgencija = imeAgencija;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
    public int vrtiVremeVoDenovi(){
        return 0;
    };

}
