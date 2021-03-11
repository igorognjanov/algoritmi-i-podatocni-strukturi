package AuditoriskiVezbi.aud07;
class ChemicalElement implements Comparable<ChemicalElement> {

    // A ChemicalElement object represents a chemical element.

    // Each element contains the two characters of the chemical symbol.
    // The first character must be an uppercase letter. Where present,
    // the second character must be a lowercase letter. If absent, the
    // second character is a space.

    private char sym1, sym2; // The two letters of the chemical symbol.


    public ChemicalElement (String symbol) {
        if (symbol.length() >= 1)
            sym1 = Character.toUpperCase(symbol.charAt(0));
        else
            sym1 = ' '; // Should really fail.
        if (symbol.length() >= 2)
            sym2 = Character.toLowerCase(symbol.charAt(1));
        else
            sym2 = ' ';
    }


    public int hashCode () {
        return sym1 - 'A';
    }


    public int stepCode () {
        return (sym2 == ' ') ? 1 : sym2 - 'a' + 2;
    }


    public String toString () {
        return "" + sym1 + sym2;
    }


    public int compareTo (ChemicalElement that) {
        return (this.sym1 < that.sym1) ? -1 :
                (this.sym1 > that.sym1) ? 1  :
                        (this.sym2 < that.sym2) ? -1 :
                                (this.sym2 > that.sym2) ? 1  :
                                        0;
    }

    @Override
    public boolean equals (Object that) {
        ChemicalElement other = (ChemicalElement)that;
        if (other == null || ! (other instanceof ChemicalElement))
            return false;
        else{
            return this.compareTo(other) == 0;
        }
    }
}



public class OBHT<K extends Comparable<K>, E> {
    public MapEntry<K, E> [] buckets;
    private int occupancy;

    private MapEntry<K, E> former = new MapEntry<>(null, null);

    public OBHT(int m) {
        this.buckets = (MapEntry<K, E>[]) new MapEntry[m];
        occupancy = 0;
    }

    public int hash(K key){
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public int search(K key){
        int b = hash(key) % buckets.length;
        int n_search = 0;
        while (true){
            MapEntry<K, E> old = buckets[b];
            if(old == null)
                return -1;
            if(old.compareTo(key) == 0)
                return b;
            else{
                b = (b + 1) % buckets.length;
                n_search ++;
                if (n_search == buckets.length)
                    return -1;
            }
        }
    }

    public void insert(K key, E value){
        int b = hash(key) % buckets.length;
        int n_search = 0;
        while (true){
            MapEntry<K, E> oldEntry = buckets[b];
            if(buckets[b] == null) {
                occupancy++;
                if(occupancy == buckets.length){
                    System.out.println("Mapata e polna");
                }
                buckets[b] = new MapEntry<>(key, value);
                return;
            }
            else if (oldEntry == former
                    || key.equals(oldEntry.key)) {
                buckets[b] = new MapEntry<>(key, value);
                return;
            }
            else {
                b = (b+1) % buckets.length;
                n_search ++;
                if(n_search == buckets.length)
                    return;
            }

        }
    }

    public void delete(K key){
        int b = hash(key) % buckets.length;
        int n_search = 0;
        while (true){
            MapEntry<K, E> oldEntry = buckets[b];
            if(oldEntry == null || oldEntry == former){
                return;
            }

            if(oldEntry.compareTo(key) == 0){
                buckets[b] = former;
                return;
            }
            else {
                b = (b+1) % buckets.length;
                n_search++;
                if (n_search == buckets.length)
                    return;
            }
        }
    }

    public String toString () {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            if (buckets[i] == null)
                temp += "\n";
            else if (buckets[i] == former)
                temp += "former\n";
            else
                temp += buckets[i] + "\n";
        }
        return temp;
    }

    public OBHT<K,E> clone () {
        OBHT<K,E> copy = new OBHT<K,E>(buckets.length);
        for (int i = 0; i < buckets.length; i++) {
            MapEntry<K,E> e = buckets[i];
            if (e != null && e != former)
                copy.buckets[i] = new MapEntry<K,E>(e.key, e.element);
            else
                copy.buckets[i] = e;
        }
        return copy;
    }

    public static void main (String[] args) {
        OBHT<ChemicalElement,Integer> table1 = new OBHT<ChemicalElement,Integer>(26);
        table1.insert(new ChemicalElement("H"),  new Integer(1));
        table1.insert(new ChemicalElement("He"), new Integer(2));
        table1.insert(new ChemicalElement("Li"), new Integer(3));
        table1.insert(new ChemicalElement("Be"), new Integer(4));
        table1.insert(new ChemicalElement("Na"), new Integer(11));
        table1.insert(new ChemicalElement("Mg"), new Integer(12));
        table1.insert(new ChemicalElement("K"),  new Integer(19));
        table1.insert(new ChemicalElement("Ca"), new Integer(20));
        table1.insert(new ChemicalElement("Rb"), new Integer(37));
        table1.insert(new ChemicalElement("Sr"), new Integer(38));
        table1.insert(new ChemicalElement("Cs"), new Integer(55));
        table1.insert(new ChemicalElement("Ba"), new Integer(56));

        System.out.println ("Initial table.");
        System.out.println(table1);

        OBHT<ChemicalElement,Integer> table2 = (OBHT<ChemicalElement,Integer>) table1.clone();

        table1.insert(new ChemicalElement("Fr"), new Integer(87));
        table1.insert(new ChemicalElement("Ra"), new Integer(88));
        table1.insert(new ChemicalElement("B"),  new Integer(5));

        System.out.println ("Table after inserting Fr, Ra and B.");
        System.out.println(table1);

        table2.delete(new ChemicalElement("Mg"));
        table2.delete(new ChemicalElement("Ca"));
        //table2.delete(new ChemicalElement("Ba"));

        System.out.println ("Initial table after deleting Mg, Ca and Ba.");
        System.out.println(table2);

        //table2.delete(new ChemicalElement("Ba"));
        table2.delete(new ChemicalElement("Be"));
        //table2.delete(new ChemicalElement("Ba"));
        table2.delete(new ChemicalElement("B"));

        System.out.println(table2);

        table2.insert(new ChemicalElement("Ba"), new Integer("56"));
        table2.insert(new ChemicalElement("Be"), new Integer("4"));

        System.out.println(table2);

        table2.delete(new ChemicalElement("Ba"));
        table2.delete(new ChemicalElement("Ba"));
        table2.delete(new ChemicalElement("Ba"));
        System.out.println(table2);


    }



}
