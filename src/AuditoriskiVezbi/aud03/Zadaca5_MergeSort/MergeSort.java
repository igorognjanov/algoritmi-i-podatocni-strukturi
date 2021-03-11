package AuditoriskiVezbi.aud03.Zadaca5_MergeSort;

public class MergeSort {
    private void merge(int array[], int l, int middle, int r){
        int[] niza = new int[r+1];

    }
    private void mergeSort(int array[], int l, int r){
        if(l == r);

        mergeSort (array, l, (l + r) / 2);
        mergeSort (array, (l + r) / 2 + 1, r);
        merge(array, l, (l+r)/2, r);
    }
}
