package AuditoriskiVezbi.aud07;

public class DoubleHashedOBHT<K extends DoublyHashable<K> & Comparable<K>, E> {
    private MapEntry<K, E>[] buckets;
    private int occupancy;

    public DoubleHashedOBHT(int m) {
        buckets = (MapEntry<K, E>[]) new MapEntry[m];
        occupancy = 0;
    }

    public int hash(K key){
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public int step(K key){
        return Math.abs(key.stepCode()) % buckets.length;
    }

    public int search(K key){
        int b = hash(key);
        int s = step(key);
        int n_search=0;
        while (true){
            MapEntry<K, E> oldEntry = buckets[b];
            if(oldEntry == null)
                return -1;
            else if(key.equals(oldEntry.key)){
                return b;
            }
            else
            {
                b = (b+s) % buckets.length;
                n_search ++;
                if(n_search == buckets.length)
                    return -1;
            }
        }
    }

}
