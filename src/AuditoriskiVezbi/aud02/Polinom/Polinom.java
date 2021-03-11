package AuditoriskiVezbi.aud02.Polinom;


import java.net.Inet4Address;
import java.util.Scanner;

import static java.lang.System.out;
import static java.lang.System.setOut;

public class Polinom {
    public Array<Integer> koeficienti;

    public Polinom(Array<Integer> koeficienti) {
        this.koeficienti = koeficienti;
    }

    public Array<Integer> getKoeficienti() {
        return koeficienti;
    }

    public void setKoeficienti(Array<Integer> koeficienti) {
        this.koeficienti = koeficienti;
    }

    @Override
    public String toString() {
        int r = this.koeficienti.get (0);
        String str = new String ();
        for(int i = 1; i < 2 * r; i += 2){
            str = str + (koeficienti.get (i+1) + "x^" + koeficienti.get (i));
            if(i != koeficienti.get (0)*2-1)
                str += " + ";
        }
        return str;
    }

    public Polinom soberi(Polinom p){
        int n = this.koeficienti.get (0);
        int m = p.koeficienti.get (0);
        Array<Integer> rez = new Array<Integer> (2*(m+n)+1);
        int i=1, j=1, k=1;
        while(i <= 2*n && j <= 2*m){
            if(this.koeficienti.get (i).equals(p.koeficienti.get (j))){
                rez.set (k+1, this.koeficienti.get (i+1) + p.koeficienti.get (j+1));
                if((rez.get (k+1) != null)){
                    rez.set (k, this.koeficienti.get (i));
                    k += 2;
                }
                i+=2;
                j+=2;
            }
            else{
                if(this.koeficienti.get (i) < p.koeficienti.get (j)){
                    rez.set (k+1, p.koeficienti.get (j+1));
                    if((rez.get (k+1) != null)){
                        rez.set (k, p.koeficienti.get (j));
                        k += 2;
                    }
                    j+=2;
                }
                else{
                    rez.set (k+1, this.koeficienti.get (i+1));
                    if((rez.get (k+1) != null)){
                        rez.set (k, this.koeficienti.get (i));
                        k += 2;
                    }
                    i+=2;
                }
            }
        }

        rez.set (0, k/2);
        return new Polinom (rez);
    }


    public static void main(String[] args) {
        Array<Integer> n1 =new Array<Integer>(10);
        Array<Integer> n2 =new Array<Integer>(10);
        n1.set(0, 2); n1.set(1, 4); n1.set(2, 2); n1.set(3, 0); n1.set(4, 3); //2*x^4 + 3
        n2.set(0, 3); n2.set(1, 3); n2.set(2, 1); n2.set(3, 2); n2.set(4, 2); n2.set(5, 0); n2.set(6, 8); //x^3 + 2*x^2 + 8
        Polinom a= new Polinom(n1);
        Polinom b= new Polinom(n2);
        Polinom c = a.soberi(b);
        System.out.print(c.toString());
       /* Scanner scanner = new Scanner (System.in);
        int L = scanner.nextInt ();
        Array<Integer> array = new Array<> (2*L+1);
        array.set (0, L);
        for(int i=1; i<=L*2; i++){
            int s = scanner.nextInt ();
            array.set (i, s);
        }
        L = scanner.nextInt ();
        Array<Integer> array2 = new Array<> (2*L+1);
        array2.set (0, L);
        for(int i=1; i<=L*2; i++){
            int s = scanner.nextInt ();
            array2.set (i, s);
        }
        Polinom polinom = new Polinom (array);
        Polinom polinom1 = new Polinom (array2);
        out.println ("Polinom: " + polinom);
        out.println ("Polinom1: " + polinom1);
        out.println ("Polinom + Polinom :" + polinom.soberi (polinom1));*/
        /*        for(int i=0; i<array.getLength (); i++)
            if(array.get (i) == null)
                out.println ("NULL" + "   " + i);*/



        /*Array<Integer> array = new Array<Integer> (s*2+1);
        array.set (0, s);
        for(int i=1; i<=s*2; i++) {
            int n = scanner.nextInt ();
            array.set (i, n);
        }
        for(int i=0; i<2*s+1; i++) if(array.get(i) == null) out.println ("NULLLLL");
        out.println (array.getLength ());
        Polinom polinom = new Polinom (array);
        out.println (polinom);
        Polinom polinom1 = new Polinom (array);
        Polinom zbir = new Polinom (polinom.soberi (polinom1));
        out.println (zbir);*/
    }
}
