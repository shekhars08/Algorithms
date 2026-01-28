package graph;

import java.util.ArrayList;
import java.util.List;

public class AdjMatrix {

//    public static void adjMatrix(int[][] edge){
//        int n = edge.length;
//
//        int[][] graph = new int[n][n];
//
//        for(int i=0; i<n; i++) {
//            int u = edge[i][0];
//            int v = edge[i][1];
//
//            graph[u][v] = 1;
//            graph[v][u] = 1;
//        }
//
//    }


    static class Pair{
        int nbr;
        int wt;

        Pair(int nbr, int wt){
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    static List<List<Pair>> graph;

    public static void adjList(int[][] edge, int n){

        graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<edge.length; i++){
            int u = edge[i][0];
            int v = edge[i][1];
            int w = edge[i][2];

            addEdge(u, v, w);
        }
    }

    private static void addEdge(int u, int v, int w) {
        graph.get(u).add(new Pair(v, w));
        graph.get(v).add(new Pair(u, w));
    }

    public static void main(String[] args) {

    }
}
