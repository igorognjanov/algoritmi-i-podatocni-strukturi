package AuditoriskiVezbi.aud09;

import java.util.Comparator;

public class Heap<E extends Comparable<E>>{

    private E[] elements;

    public Heap(int n){
        elements = (E[]) new Comparable [n];
    }

    public int getParent(int i){
        return (i+1)/2-1;
    }

    public int getLeft(int i){
        return i*2+1;
    }

    public int getRight(int i){
        return 2*i+2;
    }

    public E getAt(int i){
        return elements[i];
    }

    public void setElement(int i, E elem){
        elements[i] = elem;
    }

    public void swap(int i, int j){
        E temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    public void adjust(int i, int n){
        while (i < n){
            int left = getLeft (i);
            int right = getRight (i);
            int largest = i;

            if((left < n) && (elements[left].compareTo (elements[largest]) > 0))
                largest = left;
            if((right < n) && (elements[right].compareTo (elements[largest]) > 0))
                largest = right;
            if(i == largest)
                break;

            swap (i, largest);
            i = largest;

        }
    }

    void buildHeap() {
        int i;
        for (i=elements.length/2-1;i>=0;i--)
            adjust(i, elements.length);
    }

    public void heapSort(){
        buildHeap ();
        for (E element : elements) System.out.print (element + " ");
        System.out.println ();
        for(int i=elements.length-1; i>=0; i--){
            swap (0, i);
            adjust (0, i);
        }
    }



}
