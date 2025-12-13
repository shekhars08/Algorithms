package dp;

public class UniquePath {

    /*
     * Recursive Approach
     */

    public static int waysRecursive(int i, int j) {

        if (i < 0 || j < 0) {
            return 0;
        }

        if (i == 0 && j == 0) {
            return 1;
        }

        int hres = waysRecursive(i, j - 1);
        int vres = waysRecursive(i - 1, j);

        return hres + vres;
    }


    public static int waysDpTabulation(int n, int m){
        int[][] dp = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i == 0 && j == 0){
                    // Top left corner
                     dp[i][j] = 1;
                }
                else if(i == 0){
                    //first row, but not corner
                    dp[i][j] = 1;
                }
                else if(j == 0) {
                    //first col, but not corner
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[n-1][m-1];
    }

    /*
    * Using DP Memorisation
    * Top-Down Approach
    */


    public static int[][] dp;

    public static int waysDpMemo(int i, int j) {

        if (i == 0 || j == 0)
            return dp[i][j] = 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        int hres = waysDpMemo(i, j - 1);
        int vres = waysDpMemo(i - 1, j);

        return dp[i][j] = hres + vres;
    }

    public static int waysCount(int n, int m) {
 //    int res = waysRecursive(n-1, m-1);

//        dp = new int[n][m];
//        for (int[] arr : dp) {
//            Arrays.fill(arr, -1);
//        }
//        return waysDpMemo(n-1, m-1);


        return waysDpTabulation(n, m);

    }


    public static void main(String[] args) {

        int n = 3;
        int m = 3;

        System.out.println(waysCount(n, m));

    }
}
