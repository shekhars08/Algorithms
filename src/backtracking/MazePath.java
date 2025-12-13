package backtracking;

/**
 *  Print All Maze Paths
 * You are given the dimensions of a rectangular board of size A x B. You need to print all the possible paths from top-left corner
 * to bottom-right corner of the board.
 * You can only move down (denoted by 'D') or right (denoted by 'R') at any point in time.
 * NOTE : You need to return all the paths in Lexicographically sorted order.
 **/

public class MazePath {

    public static void main(String[] args){
        int n = 3, m = 2;
        printPaths(n, m);
    }

    public static void printPaths(int n, int m){
        solvePrintPaths(n-1, m-1, "");
    }

    public static void solvePrintPaths(int i, int j, String path){

        if(i < 0 || j < 0){
            //invalid
            return;
        }
        if(i==0 & j==0){
            //destination
            System.out.println(path);
            return;
        }

        solvePrintPaths(i-1, j, path+"D");
        solvePrintPaths(i, j-1, path+"R");
    }
}
