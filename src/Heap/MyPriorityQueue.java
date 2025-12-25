package Heap;

import java.util.ArrayList;
import java.util.List;

public class MyPriorityQueue {

    private final List<Integer> heap;

    public MyPriorityQueue() {
        heap = new ArrayList<>();
    }

    public MyPriorityQueue(List<Integer> list) {
        heap = list;
        int n = list.size();
        // parent of index = (i-1)/2; so last leaf index = (n-1-1)/2 = n-2/2
        int lastLeafIndex = (n - 2) / 2;
        for (int i = lastLeafIndex; i >= 0; i--) {
            downHeapify(i);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

//    private void downHeapify(int index) {
//        int i = index;
//        int n = heap.size();
//
//        //left child
//        int left = 2 * i + 1;
//        //right child
//        int right = 2 * i + 2;
//
//        while (left < n) {
//            int min = Math.min(heap.get(i), heap.get(left));
//            if (right < n) {
//                min = Math.min(min, heap.get(right));
//            }
//
//            if (min == heap.get(i)) {
//                break;
//            } else if (min == left) {
//                swap(i, left);
//                i = left;
//            } else if (right < n && min == right) {
//                swap(i, right);
//                i = right;
//            }
//
//        }
//    }

    private void downHeapify(int index) {
        int i = index;
        int n = heap.size();

        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left >= n) break;

            int minVal = Math.min(heap.get(i), heap.get(left));
            if (right < n) {
                minVal = Math.min(minVal, heap.get(right));
            }

            if (minVal == heap.get(i)) {
                break;
            } else if (minVal == heap.get(left)) {
                swap(i, left);
                i = left;
            } else {
                swap(i, right);
                i = right;
            }
        }
    }


    private void upHeapify() {
        int i = heap.size() - 1;
        while (i > 0) {
            int pi = (i - 1) / 2;
            if (heap.get(pi) > heap.get(i)) {
                swap(i, pi);
                i = pi;
            } else {
                break;
            }
        }
    }

    public void add(int ele) {
        heap.add(ele);
        upHeapify();
    }

    public int remove() {
        if(heap.isEmpty())  return -1;
        int n = heap.size();
        int rem = heap.getFirst();// or int rem = heap.get(0);
        swap(0, n-1);
        heap.remove(n-1);
        downHeapify(0);
        return rem;
    }

    public int peek() {
        if (heap.isEmpty())  return -1;
        return heap.getFirst(); // return heap.get(0);

    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }
}

