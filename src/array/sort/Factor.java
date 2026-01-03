package array.sort;

import java.util.Arrays;
import java.util.Comparator;

public class Factor {

    public static int factorCount(int num){
        int cnt = 0;

        for(int i=1; i*i<=num; i++){
            if(num % i == 0){
                if(i == num/i){
                    cnt += 1;
                }
                else {
                    cnt += 2;
                }
            }
        }
        return cnt;
    }

    public static void factorSort(int[] arr){
        int n = arr.length;
        Integer[] A = new Integer[n];

        for(int i=0; i<n; i++){
            A[i] = arr[i];
        }

        System.out.println("Array Before Sort : " + Arrays.toString(A));

        Arrays.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {

                int fca = factorCount(a);
                int fcb = factorCount(b);

                if(fca != fcb){
                    return fca - fcb;
                }
                else {
                    return a-b;
                }
            }
        });

        System.out.println("Array after Sort on the basis of factor cnt: " + Arrays.toString(A));
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 6, 9, 8, 2, 10};
        factorSort(arr);
    }
}
