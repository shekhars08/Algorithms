package hashing;

import java.util.HashMap;
import java.util.HashSet;

public class PairSumK {

    // Return if a pair exists A[i] + A[j] = K  and i != j and i < j

    public static boolean pairExists(int[] arr, int k){
        HashSet<Integer> set = new HashSet<>();
        for (int ele: arr){
            int rem = k - ele;
            if (set.contains(rem)){
                return true;
            }
            else {
                set.add(ele);
            }
        }
        return false;
    }

    // cnt the pair if a pair exists A[i] + A[j] = K  and i != j

    public static int cntPair(int[] arr, int k){
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele: arr){
            int rem = k - ele;
            if(map.containsKey(rem)){
                cnt += map.get(rem);
            }

            map.put(ele, map.getOrDefault(ele, 0)+1);
        }


        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 2, 5, 8, 5, 2, 8};
        int k = 10;
        System.out.println("Pair exists : " + pairExists(arr, k));
        System.out.println("Cnt of Pair : " + cntPair(arr, k));
    }
}
