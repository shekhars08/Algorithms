package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {

        // No. of vertex
        int n = 6;

        //Edges (u->v)
        int[][] edges = {
                {0,1},
                {0,2},
                {1,3},
                {2,4},
                {3,5},
        };

        // Build Graph

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n;i++){
            graph.add(new ArrayList<>());
        }

        //for(int i=0; i<edges.length; i++){
        //      int u = edges[i][0];
        //      int v = edges[i][1];
        // OR

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);

            boolean[] visited = new boolean[n];
            System.out.println("BFS Traversal: ");

            bfs(0, graph, visited);

        }
    }

    private static void bfs(int src, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()){
            // remove
            int curr = queue.remove();
            // work (print)
            System.out.println(curr + " ");
            // add unvisited nbr, mark them as well
            for(int nbr : graph.get(curr)){
                if (!visited[nbr]){
                    visited[nbr] = true;
                    queue.add(nbr);
                }
            }
        }
    }
}
