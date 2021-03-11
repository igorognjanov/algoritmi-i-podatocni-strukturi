package AuditoriskiVezbi.aud01.Zadaca2;

public class Kompanija {
    private Vraboten [] vraboteni;

    public Kompanija(Vraboten [] vraboteni){
        this.vraboteni = vraboteni;
    }
    public Vraboten najangaziran(){
        int max = 0;
        for(int i=0; i<vraboteni.length; i++){
            if(vraboteni[i].vkupnoCasovi () > vraboteni[max].vkupnoCasovi ()) max = i;
        }
        return vraboteni[max];
    }

    public void pecati(){
        //sort
        for(int i=0; i<vraboteni.length; i++){
            for (int k=0; k<vraboteni.length-i-1; k++){
                if(vraboteni[k].vkupnoCasovi () < vraboteni[k+1].vkupnoCasovi ()) {
                    Vraboten temp = vraboteni[k];
                    vraboteni[k] = vraboteni[k+1];
                    vraboteni[k+1] = temp;
                }
            }
        }
        for(int i=0; i<vraboteni.length; i++) System.out.println (vraboteni[i]);
    }

    public static void main(String[] args) {

    }
}
