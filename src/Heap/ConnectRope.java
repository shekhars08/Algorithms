package Heap;

import java.util.PriorityQueue;
import java.util.Scanner;

/*
    Connecting ropes

    You are given an array A of integers that represent the lengths of ropes. You need to connect
    these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.
    Find and return the minimum cost to connect these ropes into one rope.
 */

public class ConnectRope {
    public static int connectingRopes(int[] arr) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int ele: arr){
            pq.add(ele);
        }

        int cost = 0;

        while (pq.size() > 1){
            int r1 = pq.remove();
            int r2 = pq.remove();

            cost += r1+r2;
            pq.add(r1+r2);
        }

        return cost;
    }

    public static int demo3(int[] arr, int n){
        int ans = 0;
        int prev = arr[0];
        for(int i = 1; i<n; i++){
            if(prev > arr[i]){
                ans += prev - arr[i];
                prev = arr[i];
            }
            else {
                prev = arr[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter Array Elements are : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            System.out.println("Array: " + arr[i]);
        }

        int x = demo3(arr, n);
        System.out.println("Ans: "+ x);
    }
}
