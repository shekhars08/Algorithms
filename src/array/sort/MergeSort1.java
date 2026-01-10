package array.sort;

import java.util.Arrays;

public class MergeSort1 {

    private static void mergeSort(int[] arr, int[] temp, int lo, int hi) {
        if(lo >= hi){
            return;
        }

        int mid = (hi+lo)/2;

        mergeSort(arr, temp, lo, mid);
        mergeSort(arr, temp, mid+1, hi);

        mergeTwoSortedArray(arr, temp, lo, hi, mid);
    }

    private static void mergeTwoSortedArray(int[] arr, int[] temp, int lo, int hi, int mid) {

        int i = lo, j = mid+1, k  = lo;

        while(i <= mid && j <= hi){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i<= mid)
            temp[k++] = arr[i++];

        while(j <= hi){
            temp[k++] = arr[j++];
        }

        for(int l=0; l<=hi; l++){
            arr[l] = temp[l];
        }
    }

    public static void main(String[] args) {

        int[] arr = {21, 5, 11, 4, 8, 9, 2, -6, 11};
        int n = arr.length;
        int[] temp = new int[n];
        System.out.println("Array Before Sort : " + Arrays.toString(arr));

        mergeSort(arr, temp, 0, n-1);

        System.out.println("Array After Merge Sort : " + Arrays.toString(arr));

    }
}
