package LaboratoriskiVezbi.vezba1.zadaca2;



public class Maraton implements IMaraton{
    private String place;
    private int year;
    private Atleticar [] niza;

    public Maraton() {
        niza = new Atleticar[0];
    }

    public Maraton(String place, int year, Atleticar[] niza) {
        this.place = place;
        this.year = year;
        this.niza = niza;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Atleticar[] getNiza() {
        return niza;
    }

    public void setNiza(Atleticar[] niza) {
        this.niza = niza;
    }

    @Override
    public Atleticar najdobroVreme() {
        int maxIndex=0;
        for(int i=0; i<niza.length; i++){
            if(niza[maxIndex].getTime () < niza[i].getTime ()) maxIndex = i;
        }
        return niza[maxIndex];
    }

    @Override
    public int atleticariOd(String s) {
        int count=0;
        for(int i=0; i<niza.length; i++){
            if(niza[i].getCountry ().equals (s)) count++;
        }
        return count;
    }
}
