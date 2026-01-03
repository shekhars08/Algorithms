package array.sort;

import java.util.Arrays;

public class QuickSort {

    public static int partitionIndex(int[] arr, int lo, int hi){
        int pivot = arr[hi];
        int i = lo;
        int j = lo;

        while(j < hi){
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
            j++;
        }

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return i;

    }

    public static void quickSort(int[] arr, int lo, int hi) {

        if(lo >= hi){
            return;
        }

        int pi = partitionIndex(arr, lo, hi);
        quickSort(arr, lo, pi-1);
        quickSort(arr, pi+1, hi);
    }

    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    public static void main(String[] args) {
        int[] arr = {17, 23, 16, 6, 9, 14, 8, 12};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println("Array after Quick Sort");
        System.out.println(Arrays.toString(arr));

    }
}
