package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MST {
    //Prims Algorithm

    public static class Edge {
        int nbr;
        int wt;

        Edge(int nbr, int wt){
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static class Pair{
        int u;
        int v;
        int wt;

        Pair(int u, int v, int wt){
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    public static List<ArrayList<Edge>> graph;

    private static int primsAlgorithm() {
        int n = graph.size();
        boolean[] vis = new boolean[n];

        int minCost = 0;
        int src = 0;
        vis[src] = true;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.wt));

        // first edge is added here
        for (Edge e: graph.get(src)){
            pq.add(new Pair(src, e.nbr, e.wt));
        }

        // Now algo starts

        while(!pq.isEmpty()){

            // remove
            Pair curr = pq.remove();

            // mark * (means mark t/f)
            if(vis[curr.v] == true){
                continue;
            }
            vis[curr.v] = true;

            // work (means add cost or edge to make mst)
            //since here we have edge available in Pair,
            //if my task is to make MST graph, then I can add edge in a new graph
            // for now we are just adding cost

            minCost += curr.wt;

            // add unvisited nbr

            for (Edge e : graph.get(curr.v)){
                if (vis[e.nbr] == false){
                    pq.add(new Pair(curr.v, e.nbr, e.wt));
                }
            }
        }

        return minCost;
    }

    public static int minSpanningTree() {
        return primsAlgorithm();
    }

    public static void main(String[] args) {

        int n = 4;
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(0, 1, 2);
        addEdge(1, 2, 8);
        addEdge(2, 3, 5);
        addEdge(3, 0, 6);
        addEdge(0, 2, 3);

        // 3. Calculate and print the result
        int res = minSpanningTree();
        System.out.println("The Minimum Cost of the Spanning Tree is: " + res);

    }

    private static void addEdge(int u, int v, int wt) {
        graph.get(u).add(new Edge(v, wt));
        graph.get(v).add(new Edge(u, wt));
    }
}
