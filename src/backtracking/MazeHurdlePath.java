package backtracking;

/**
 * Shortest path in a Binary Maze with Hurdles

 * Given an MxN matrix where each element can either be 0 or 1. We need to find the length of shortest path
 * between a given source cell to a destination cell.
 * A cell with value 0 denotes that it's a hurdle. The path can only be created out of the cells with values 1.
 * If NO path exists then print -1.

 * The matrix A is given as input of size M x N.
 * The coordinates of Source cell are given by B, C.
 * The coordinates of Destination cell are given by D, E.
 */

public class MazeHurdlePath {

    static int[] rdir = {-1, 0, 1, 0};
    static int[] cdir = {0, -1, 0, 1};

    public static int solveMinPath(int[][] mat, int i, int j, int dr, int dc){

        if(i == dr && j == dc){
            return 0;
        }

        mat[i][j] = -1; //mark
        int res = Integer.MAX_VALUE;
        for(int dir = 0; dir < 4; dir++){
            int r = i + rdir[dir];
            int c = j + cdir[dir];
            if((0 <= r && r < mat.length) && (0 <= c && c < mat[0].length) && mat[r][c] == 1){
                int len = solveMinPath(mat, r, c, dr, dc);
                res = Math.min(res, len);
            }
        }
        mat[i][j] = 1; // unmark
        return res == Integer.MAX_VALUE ? res: res+1;
    }

    public static int mazeMinPath(int[][] mat, int sr, int sc, int dr, int dc){
        int ans = solveMinPath(mat, sr, sc, dr, dc);
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }

    public static void main(String[] args){
        int[][] mat = {
                {1, 0, 1, 0},
                {1, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 1, 1},
        };

        int sr = 0, sc = 0, dr = 2, dc = 3;
        System.out.println(mazeMinPath(mat, sr, sc, dr, dc));

    }

}
