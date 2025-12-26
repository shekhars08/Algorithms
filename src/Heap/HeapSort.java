package Heap;

import java.util.Arrays;

public class HeapSort {

    public static void heapSort(int[] A) {
        int n = A.length;

        // Build Max-Heap
        buildMaxHeap(A);

        int j = n - 1;
        while (j > 0) {
            swap(A,0, j);
            j--;
            // Consider arr from 0 to j
            downHeapify(A, 0, j);
        }
    }

    private static void buildMaxHeap(int[] A) {
        int n = A.length;
        int lastLeafIndex = (n - 2) / 2;
        for (int i = lastLeafIndex; i >= 0; i--) {
            downHeapify(A, i, n-1);
        }
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static void downHeapify(int[] A, int i, int j) {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left <= j && A[left] > A[largest]) {
                largest = left;
            }

            if (right <= j && A[right] > A[largest]) {
                largest = right;
            }

            if (largest == i) {
                break;
            }
            else {
                swap(A, i, largest);
                i = largest;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 12, 5, 4, -1, 7,};
        System.out.println("Array: before sort: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("Array: after sort: " + Arrays.toString(arr));
    }
}
