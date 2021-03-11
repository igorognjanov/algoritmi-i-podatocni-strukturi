package LaboratoriskiVezbi.vezba1.zadaca1;

public class GodishenOdmor extends Patuvanje{
    public int denovi;


    public GodishenOdmor(){
    }

    public GodishenOdmor(int denovi) {
        this.denovi = denovi;
    }

    public GodishenOdmor(String imeAgencija, int cena, int denovi) {
        super (imeAgencija, cena);
        this.denovi = denovi;
    }

    public int getDenovi() {
        return denovi;
    }

    public int vratiVremeVoDenovi(){
        return denovi;
    }

}
