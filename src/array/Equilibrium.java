package array;

import java.util.Scanner;

/**
 *  Equilibrium index of an array
 *  The equilibrium index of an array is an index such that the sum of elements at lower indexes is
 *  equal to the sum of elements at higher indexes.
 *  Note:
 *  lSum == rSum
 *  lSum => (0, i-1) => prefix[i-1]
 *  rSum => (i+1, n-1) => prefix[n-1] - prefix[i+1-1] => prefix[n-1] - prefix[i]
 **/
class Equilibrium {

    public static int equilibrium(int[] arr, int n){

        long[] prefix = new long[n];
        prefix[0] = arr[0];
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }

        int ans = -1;
        long lSum, rSum;

        for(int i=0; i<n; i++){
            lSum = (i > 0) ? prefix[i-1]: 0;
            rSum = prefix[n-1] - prefix[i];

            if(lSum == rSum){
                ans = i;
                break;
            }
        }

        return ans;
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

        int ans = equilibrium(arr, n);
        System.out.println(" Equilibrium index of an array is: "+ans);
    }
}
