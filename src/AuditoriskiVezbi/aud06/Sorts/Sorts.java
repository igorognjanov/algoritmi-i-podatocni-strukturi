package AuditoriskiVezbi.aud06.Sorts;

import java.text.CollationElementIterator;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Sorts {

    // Insertion sort

    public static <T extends Comparable<? super T>> void insertionSort(T[] array){
        int begin = 0;
        int end = array.length-1;
        int index;
        T key;
        int i;

        for(index = begin+1; index<=end; index++){
            key = array[index];
            i=index-1;
            while (i>=begin && array[i].compareTo (key)>0){
                array[i+1] = array[i];

                i--;
            }
            array[i+1] = key;
        }
    }


    // Bubble sort

    public static <T extends Comparable<? super T>> void bubbleSort(T[] array){
        int begin = 0;
        int end = array.length-1;
        int index;
        int i;
        boolean flipped;

        for(index=end; index>begin; index--){
            flipped = false;
            for(i=0; i<index; i++){
                if(array[i].compareTo (array[i+1]) > 0){
                    T temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;

                    flipped = true;
                }
            }
            if (!flipped)
                break;
        }
    }


    // Merge sort

    public static <T extends Comparable<? super T>> void mergeSort(T[] array, int l, int middle, int r) {
        T[] temp = (T[]) new Comparable[array.length];

        int i = l;
        int j = middle + 1;
        int k = 0;

        while (j <= r && i <= middle) {
            if (array[i].compareTo (array[j]) < 0) {
                temp[k] = array[i];
                i++;
            } else {
                temp[k] = array[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            temp[k] = array[i];
            k++;
            i++;
        }
        while (j <= r) {
            temp[k] = array[j];
            k++;
            j++;
        }
        for(k=0; k<r-l+1; k++){
            array[l+k] = temp[k];
        }
    }
    public static <T extends Comparable<? super T>> void merge(T[] array, int l, int r){
        if(l == r) return;

        int middle = (l+r)/2;
        merge (array, l, middle);
        merge (array, middle+1, r);
        mergeSort (array, l, middle, r);
    }


    // Quick sort

    public static <T extends Comparable<? super T>> void quickSort(T[] array, int l, int r){
        int pivot_index = partition (array, l, r);
        System.out.println ("Pivot index: " + pivot_index);
        if(pivot_index-1 > l)
            quickSort (array, l, pivot_index-1);
        if(pivot_index < r)
            quickSort (array, pivot_index, r);
    }


    public static <T extends Comparable<? super T>> int partition(T[] array, int l, int r){
        int i = l;
        int j = r;
        T pivot = array[(l+r)/2];
        while (i <= j){
            while (array[i].compareTo (pivot) < 0)
                i++;
            while (array[j].compareTo (pivot) > 0)
                j--;

            if(i<=j) {
                T temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
            j--;
            i++;

        }
        return i;
    }



    // Counting sort

    public static void countingSort(Integer[] a, int l){
        int[] b = new int[l+1];
        int[] c = new int[a.length];
        int i;

        for(i=0; i<=l; i++)
            b[i] = 0;
        for(i=0; i<a.length; i++)
            b[a[i]]++;
        for(i=1; i<=l; i++)
            b[i] += b[i-1];
        for(i=0; i<a.length; i++){
            c[b[a[i]] - 1] = a[i];
            b[a[i]] -= 1;
        }

        for(i=0; i<a.length; i++)
            a[i] = c[i];
    }



    // Bucket sort

    public static void bucketSort(Integer[] a, int k){
        int[] b = new int[k+1];
        int i, j, pos=0;

        for(i=0; i<k+1; i++)
            b[i] = 0;
        for(i=0; i<a.length; i++)
            b[a[i]]++;
        for(i=0; i<k+1; i++)
            for(j=0; j<b[i]; j++)
                a[pos++] = i;

    }


    public static void radixSort(Integer[] array){
        Integer[] pom = new Integer[array.length];
        int i, max = array[0];
        int exp = 1;

        for(i=1; i<array.length; i++)
            if(max < array[i])
                max = array[i];


        while (max / exp > 0){
            int[] bucket = new int[10];
            for(i=0; i<10; i++)
                bucket[i] = 0;

            for (i=0; i<array.length; i++)
                bucket[array[i] / exp % 10] ++;

            for(i=1; i<10; i++)
                bucket[i] += bucket[i-1];

            for(i=array.length-1; i>=0; i--){
                pom[--bucket[array[i] / exp % 10]] = array[i];
            }
            for (i=0; i<array.length; i++)
                array[i] = pom[i];
            exp *= 10;
        }
    }



//
//    public static void radixSort(Integer A[]){
//        Integer[] pom = new Integer[A.length];
//        int i, max = A[0], exp = 1;
//
//        for (i = 0; i < A.length; i++)
//        {
//            if (A[i] > max)
//                max = A[i];
//        }
//
//        while (max / exp > 0)
//        {
//            int bucket[] =  new int[10];
//            for (i = 0; i < A.length; i++)
//                bucket[A[i] / exp % 10]++;
//            for (i = 1; i < 10; i++)
//                bucket[i] += bucket[i - 1];
//            for (i = A.length - 1; i >= 0; i--)
//                pom[--bucket[A[i] / exp % 10]] = A[i];
//            for (i = 0; i < A.length; i++)
//                A[i] = pom[i];
//            exp *= 10;
//        }
//
//    }
//





    public static Integer[] getRandomArray(){
        Integer[] array = new Integer[10] ;
        Random random = new Random ();
        for(int i=0; i<10; i++)
            array[i] = random.nextInt (50);
        return array;
    }

    public static Integer[] getRandomArray2(){
        Integer[] array = new Integer[10] ;
        Random random = new Random ();
        for(int i=0; i<10; i++)
            array[i] = random.nextInt (10000) + 1;
        return array;
    }

    public static <T extends Comparable<? super T>> boolean check(T[] array, T[] array2){
        return Arrays.compare (array, Arrays.stream (array).sorted ().collect (Collectors.toList ()).toArray (array2)) == 0;
    }

    public static void printArray(Integer[] array){
        for(int i=0; i<array.length; i++)
            System.out.print (array[i] + "  ");
        System.out.println ();
    }

    public static void main(String[] args) {
        Integer[] array;
        Integer[] array2;

        array = getRandomArray ();
        array2 = new Integer[array.length];


        System.out.println ("Insertion sort");
        printArray (array);
        insertionSort (array);
        printArray (array);
        System.out.println (check (array, array2));

        array = getRandomArray ();
        array2 = new Integer[array.length];
        System.out.println ("Bubble sort");
        printArray (array);
        bubbleSort (array);
        printArray (array);
        System.out.println (check (array, array2));

        array = getRandomArray ();
        array2 = new Integer[array.length];
        System.out.println ("Merge sort");
        printArray (array);
        merge (array, 0, array.length-1);
        printArray (array);
        System.out.println (check (array, array2));

        array = getRandomArray ();
        array2 = new Integer[array.length];
        System.out.println ("Quick sort");
        printArray (array);
        quickSort (array, 0, array.length-1);
        printArray (array);
        System.out.println (check (array, array2));

        array = getRandomArray ();
        array2 = new Integer[array.length];
        System.out.println ("Counting sort");
        printArray (array);
        countingSort (array, 49);
        printArray (array);
        System.out.println (check (array, array2));

        array = getRandomArray ();
        array2 = new Integer[array.length];
        System.out.println ("Bucket sort");
        printArray (array);
        bucketSort (array, 49);
        printArray (array);
        System.out.println (check (array, array2));

        array = getRandomArray2 ();
        array2 = new Integer[array.length];
        System.out.println ("Radix sort");
        printArray (array);
        radixSort (array);
        printArray (array);
        System.out.println (check (array, array2));

    }
}
