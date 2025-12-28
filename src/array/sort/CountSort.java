package array.sort;

import java.util.Arrays;

public class CountSort {

    public static void countSort1(int[] arr) {
        int max = arr[0];
        for (int k : arr) {
            max = Math.max(max, k);
        }

        int[] fmap = new int[max + 1];
        for (int ele : arr) {
            fmap[ele]++;
        }

        int index = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < fmap[i]; j++) {
                arr[index] = i;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 7, 9, 6, 5,12, 7, 3, 3, 3, 1, 12};

        System.out.println("Initial Array : " + Arrays.toString(arr));
        countSort1(arr);
        System.out.println("Sorted Array : " + Arrays.toString(arr));
    }
}
