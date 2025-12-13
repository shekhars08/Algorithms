package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Heap {

    public static void demo() {
        //Demo of Priority Queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(12);
        pq.add(22);
        pq.add(34);
        pq.add(36);
        pq.add(13);
        pq.add(2);
        pq.add(9);


        while (!pq.isEmpty()){
            int rem = pq.peek();
            pq.remove();
            System.out.print("Removed Heap MIN :" +rem);
        }

    }

    public static void demo2() {
        //Demo of Priority Queue
        //Max Heap

        //PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());

        // Custom to max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return -(a-b);
            }
        });

        pq.add(12);
        pq.add(22);
        pq.add(34);
        pq.add(36);
        pq.add(13);
        pq.add(2);
        pq.add(9);


        while (!pq.isEmpty()){
            int rem = pq.peek();
            pq.remove();
            System.out.print("Removed Heap MIN :" +rem);
        }

    }

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
        //demo();
        //demo2();

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
