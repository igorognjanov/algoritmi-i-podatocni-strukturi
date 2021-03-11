package AuditoriskiVezbi.aud01.Zadaca2;

import java.util.Arrays;
import java.util.Scanner;

public class Vraboten {
    private String ime;
    private String prezime;
    private static double BOD = 50;
    private double plata;
    private int staz;
    private int brBodovi;
    private Zadaca[] zadaci;
    private int brZadaci;

    public Vraboten() {
        zadaci = new Zadaca[10];
        brZadaci = 0;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public static void setBOD(double BOD) {
        Vraboten.BOD = BOD;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public void setStaz(int staz) {
        this.staz = staz;
    }

    public void setBrBodovi(int brBodovi) {
        this.brBodovi = brBodovi;
    }

    public void setZadaci(Zadaca[] zadaci, int brZadaci) {
        this.zadaci = new Zadaca[brZadaci];
        this.brZadaci = brZadaci;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public static double getBOD() {
        return BOD;
    }

    public double getPlata() {
        return brBodovi * BOD;
    }

    public int getStaz() {
        return staz;
    }

    public int getBrBodovi() {
        return brBodovi;
    }

    public Zadaca[] getZadaci() {
        return zadaci;
    }

    public int getBrZadaci() {
        return brZadaci;
    }

    public Vraboten(String ime, String prezime, int staz, int brBodovi) {
        this.ime = ime;
        this.prezime = prezime;
        this.staz = staz;
        this.brBodovi = brBodovi;
        this.plata = brBodovi * BOD;
        this.zadaci = new Zadaca[10];
        this.brZadaci = 0;
    }

    @Override
    public String toString() {
        return ime + '\t' + prezime + '\t' + getPlata () + "\t\tVkupno casovi:\t" + vkupnoCasovi ();
    }
    public void dodajZadaca(Zadaca zadaca) {
        if (brZadaci == 10) System.out.println ("Ne moze da se dodade zadaca.");
        else this.zadaci[brZadaci++] = zadaca;
    }

    public double procentZavrseni() {
        int count = 0;
        for (int i = 0; i < brZadaci; i++) {
            if (zadaci[i].isStatus ()) count++;
        }
        return (double) count / brZadaci;
    }

    public int vkupnoCasovi() {
        int count = 0;
        for (int i = 0; i < brZadaci; i++) count += zadaci[i].getBrCasovi ();
        return count;
    }

    public static void main(String[] args) {
        Vraboten emp = new Vraboten ("Igor", "Ognjanov", 0, 10);
        Vraboten emp2 = new Vraboten ("Atanas", "Ognjanov", 30, 100);
        Vraboten emp3 = new Vraboten ("Velika", "Ognjanova", 15, 120);

        Zadaca zad = new Zadaca ("navodnuvanje", 4, false);
        Zadaca zad2 = new Zadaca ("cistenje", 2, true);
        Zadaca zad3 = new Zadaca ("belenje", 20, false);
        Zadaca zad4 = new Zadaca ("brisenjePrasina", 3, false);

        emp.dodajZadaca (zad);
        emp.dodajZadaca (zad2);
        emp.dodajZadaca (zad3);

        emp2.dodajZadaca (zad);
        emp2.dodajZadaca (zad2);

        emp3.dodajZadaca (zad);
        emp3.dodajZadaca (zad2);
        emp3.dodajZadaca (zad4);

        Vraboten [] vraboteni = new Vraboten[3];
        vraboteni[0] = emp;
        vraboteni[1] = emp2;
        vraboteni[2] = emp3;


        Kompanija ko = new Kompanija (vraboteni);
        System.out.println("Najangaziran rabotnik:  "  +  ko.najangaziran ());
        ko.pecati ();
    }


}
