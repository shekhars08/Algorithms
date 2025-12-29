package array.sort;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeTwoSortedOddEven(int[] arr) {

        int oddCnt = 0;
        int evenCnt = 0;

        for(int ele: arr){
            if((ele & 1) == 0){
                evenCnt++;
            }
            else {
                oddCnt++;
            }
        }

        int[] odd = new int[oddCnt];
        int[] even = new int[evenCnt];

        int i = 0, j = 0;
        for(int ele: arr){
            if((ele & 1) == 0){
                even[i] = ele;
                i++;
            }
            else {
                odd[j] = ele;
                j++;
            }
        }

        return mergeTwoSortedArray(odd, even);
    }

    private static int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {

        int n = arr1.length;
        int m = arr2.length;

        int[] ans = new int[n+m];

        int i=0, j=0, k=0;

        while(i < n && j < m){
            if(arr1[i] < arr2[j]){
                ans[k] = arr1[i];
                i++;
            }
            else {
                ans[k] = arr2[j];
                j++;
            }
            k++;
        }

        while(i < n){
            ans[k] = arr1[i];
            i++;
            k++;
        }

        while(j < m){
            ans[k] = arr1[j];
            j++;
            k++;
        }
        return ans;

    }

    public static int[] mergeSort(int[] arr, int lo, int hi){

        // base case
        if(lo == hi){
            //return new int[]{arr[lo]}; OR

            int[] bres = new int[1];
            bres[0] = arr[lo];
            return bres;
        }

        int mid = (hi+lo)/2;
        int[] left = mergeSort(arr, lo, mid);
        int[] right = mergeSort(arr, mid+1, hi);

        return mergeTwoSortedArray(left, right);
    }

    public static void main(String[] args) {

        int[] arr = {2, 5, 4, 8, 11, 13, 10, 15, 21};
        System.out.println("Array with Odd & Even sorted : " + Arrays.toString(arr));
        int[] res = mergeTwoSortedOddEven(arr);
        System.out.println("Merge Two Odd & Even Sorted Array : " +Arrays.toString(res));



    }
}
