package AuditoriskiVezbi.aud07;

public class CBHT<K extends Comparable<K>, E> {
    public SLLNode<MapEntry<K, E>>[] buckets;

    public CBHT(int m){
        buckets = new SLLNode[m];
    }

    public int hash(K key){
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntry<K, E>> search(K targetKey){
        int b = hash(targetKey);
        SLLNode<MapEntry<K, E>> temp = buckets[b];
        while (temp != null){
            if(targetKey.equals(temp.element.key))
                return temp;
            temp = temp.succ;
        }
        return null;
    }

    public void insert(K key, E value){
        int b = hash(key);
        MapEntry<K, E> newEntry = new MapEntry<>(key, value);
        SLLNode<MapEntry<K, E>> temp = buckets[b];
        while (temp != null){
            if(key.equals(temp.element.key)){
                temp.element = newEntry;
                return;
            }
            temp = temp.succ;
        }
        buckets[b] = new SLLNode<>(newEntry, buckets[b]);
    }
    public void delete(K key) {
        // Delete the entry (if any) whose key is equal to key from this CBHT.
        int b = hash(key);
        for (SLLNode<MapEntry<K,E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
            if (key.equals(((MapEntry<K,E>) curr.element).key)) {
                if (pred == null)
                    buckets[b] = curr.succ;
                else
                    pred.succ = curr.succ;
                return;
            }
        }
    }
    public String toString() {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            for (SLLNode<MapEntry<K,E>> curr = buckets[i]; curr != null; curr = curr.succ) {
                temp += curr.element.toString() + " ";
            }
            temp += "\n";
        }
        return temp;
    }

}
