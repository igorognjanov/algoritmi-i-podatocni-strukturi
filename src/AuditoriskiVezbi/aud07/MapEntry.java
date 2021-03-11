package AuditoriskiVezbi.aud07;


public class MapEntry<K extends Comparable<K>, E>{
    public K key;
    public E element;

    public MapEntry(K key, E element) {
        this.key = key;
        this.element = element;
    }

    public int compareTo(K key){
        return this.key.compareTo(key);
    }

    public String toString(){
        return "<" + this.key + ", " + this.element + ">";
    }
}
