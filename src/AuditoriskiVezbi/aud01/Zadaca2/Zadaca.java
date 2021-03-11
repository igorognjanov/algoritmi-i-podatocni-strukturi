package AuditoriskiVezbi.aud01.Zadaca2;

public class Zadaca {
    private String opis;
    private int brCasovi;
    private boolean status;

    public Zadaca() {
    }

    public Zadaca(String opis, int brCasovi, boolean status) {
        this.opis = opis;
        this.brCasovi = brCasovi;
        this.status = status;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setBrCasovi(int brCasovi) {
        this.brCasovi = brCasovi;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getOpis() {
        return opis;
    }

    public int getBrCasovi() {
        return brCasovi;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public String toString() {
        String str = "opis='" + opis + '\'' +
                ", brCasovi=" + brCasovi +
                ", status=";
        if(status) return str + "aktivna}";
        else return str+"neaktivna";
    }
}

