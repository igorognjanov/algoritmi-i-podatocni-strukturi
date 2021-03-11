package AuditoriskiVezbi.aud09;

import java.util.Random;

public class HeapTest {

    public static void main(String[] args) {
        int i;
        int n=10;
        Random r = new Random(System.currentTimeMillis());

        Heap<Integer> heap = new Heap<Integer>(n);

        for (i=0;i<n;i++)
            heap.setElement(i, r.nextInt(2*n));

        for(i=0; i<n; i++)
            System.out.print (heap.getAt (i) + " ");
        System.out.println ();

        heap.heapSort();

        for(i=0; i<n; i++)
            System.out.print (heap.getAt (i) + " ");
        System.out.println ();

        for (i=1;i<n;i++) {
            if (heap.getAt(i-1).compareTo(heap.getAt(i)) > 0)
                System.out.println("ERROR");
        }

    }
}


