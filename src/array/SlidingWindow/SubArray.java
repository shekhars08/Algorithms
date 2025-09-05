package array.SlidingWindow;

import java.util.Scanner;

/**
 *  To find the maximum sum of the sub array given length of 'k' in an array
 *  Sliding Window Technique
 **/


class SubArray {
    public static int maxSubArray(int[] arr, int k) {
        int maxSum = 0;
        int n = arr.length;
        int l = 0, r = k - 1;
        int sum = 0;
        for (int i = l; i < r; i++) {
            sum += arr[i];
        }
        maxSum = sum;

        while (r < n - 1) {
            sum = sum - arr[l];
            l++;
            r++;
            sum = sum + arr[r];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Array Size : ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the Array Elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("The array elements are:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("Enter the size of SubArray :");
        int k = sc.nextInt();

        int ans = maxSubArray(arr, k);
        System.out.println("The Maximum sum of the SubArray of size: " + k + " is " + ans);

    }
}
