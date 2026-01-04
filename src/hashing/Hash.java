package hashing;

import java.util.Arrays;
import java.util.HashMap;

public class Hash {

    private static int[] frequencyOfQuery(int[] arr, int[] que) {
        int n = arr.length;
        int q = que.length;
        int[] res = new int[q];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int ele = arr[i];
            if (map.containsKey(ele)){
                int oldFreq = map.get(ele);
                map.put(ele, oldFreq+1);
            }
            else {
                map.put(ele, 1);
            }
        }
        for(int i=0; i<q; i++){
            int ele = que[i];
            if(map.containsKey(ele)){
                res[i] = map.get(ele);
            }
            else{
                res[i] = 0;
            }

        }
        return res;
    }

    private static int[] frequencyOfQuery1(int[] arr, int[] que) {

        int q = que.length;
        int[] res = new int[q];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        for(int i=0; i<q; i++){
            int ele = que[i];
            res[i] = map.getOrDefault(ele, 0);
        }
        return res;
    }



    public static void main(String[] args) {
        int[] arr = {2, 6, 3, 8, 2, 8, 10, 6, 2, 8};
        int[] que = {2, 8, 3, 5};

        int[] res = frequencyOfQuery(arr, que);
        System.out.println(Arrays.toString(res));
        int[] res1 = frequencyOfQuery1(arr, que);
        System.out.println(Arrays.toString(res1));

    }



}
