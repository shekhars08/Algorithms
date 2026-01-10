package dp;

import java.util.Arrays;

public class PerfectSquareCnt {

  /* Using DP
    TC - O(n)
    SC - O(n)
    Memoization (Top - Down)
  */
    public static int countOfPerfectSquare(int n){

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        if(n == 0 || n == 1)  return dp[n] = n;

        if(dp[n] != -1) return dp[n];
        int minCnt = Integer.MAX_VALUE;
        for(int i=1; i*i<=n; i++){
            int rRes = countOfPerfectSquare(n-i*i);
            minCnt = Math.min(minCnt, rRes);
        }

        return dp[n] = minCnt+1;
    }

    public static void main(String[] args) {

        int n = 12;
        int res = countOfPerfectSquare(n);
        System.out.println(res);

    }
}

/* Using Tabulation
      TC - O(n * √n)
      SC - O(n)
      Tabulation (Bottom-Up)

public static int countOfPerfectSquare(int n) {
    int[] dp = new int[n + 1];

    // Base cases
    dp[0] = 0; // 0 can be represented by 0 perfect squares
    dp[1] = 1; // 1 can be represented by 1 perfect square (1 itself)

    // Fill the dp array
    for (int i = 2; i <= n; i++) {
        dp[i] = Integer.MAX_VALUE; // Initialize with maximum value
        for (int j = 1; j * j <= i; j++) {
            int perfectSquare = j * j;
            dp[i] = Math.min(dp[i], dp[i - perfectSquare] + 1);
        }
    }

    return dp[n];
}
*/

/*
This is the Recursive Approach

TC -> O(root(n)^n)
SC -> O(n) -- because of recursion stack (n-levels)

public static int countOfPerfectSquare(int n){

    if(n == 0 || n == 1)  return n;

    int minCnt = Integer.MAX_VALUE;
    for(int i=1; i*i<=n; i++){
        int rRes = countOfPerfectSquare(n-i*i);
        minCnt = Math.min(minCnt, rRes);
    }
    return minCnt+1;
}
 */
