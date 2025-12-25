package Heap;

import java.util.Comparator;
import java.util.Scanner;

public class Heap {


    public static void minHeap() {

        //Demo of Priority Queue
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();

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

    static void maxPriorityQueue(){

        //Demo of Priority Queue
        //Max Heap

        //PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());

        // Custom to max heap
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>(new Comparator<Integer>() {
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
            System.out.print("Removed Heap MAX :" +rem);
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        maxPriorityQueue();
    }
}
