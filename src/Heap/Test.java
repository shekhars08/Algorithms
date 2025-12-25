package Heap;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        MyPriorityQueue pq = new MyPriorityQueue();
        pq.add(10);
        pq.add(5);
        pq.add(15);
        pq.add(2);

        System.out.println("Peek (should be 2): " + pq.peek()); // 2

        System.out.println("Removing elements in order:");
        while (!pq.isEmpty()) {
            System.out.print(pq.remove() + " "); // Should print: 2 5 10 15
        }
        System.out.println("\n");

        // Test 2: Bulk construction (Build Heap)
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(20, 10, 30, 5, 1));
        MyPriorityQueue pqBulk = new MyPriorityQueue(list);

        System.out.println("Bulk Build - Peek (should be 1): " + pqBulk.peek());
        System.out.println("Removing elements in order:");
        while (!pqBulk.isEmpty()) {
            System.out.print(pqBulk.remove() + " "); // Should print: 1 5 10 20 30
        }
    }
}
