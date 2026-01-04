package hashing;

import java.util.Arrays;
import java.util.HashSet;

public class DistinctElement {
    public static void main(String[] args) {
        int[] arr = {2, 6, 3, 8, 2, 8, 10, 6, 2, 8, 18, 3, 6, 2, 9, 6, 5};

        int res = cntDistinctElement(arr);
        System.out.println(res);
    }

    private static int cntDistinctElement(int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int ele: arr){
            hashSet.add(ele);
        }
        return hashSet.size();
    }
}
