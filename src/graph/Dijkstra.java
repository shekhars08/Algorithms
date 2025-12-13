package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {

    static class Edge{
        int nbr;
        int wt;
        Edge(int nbr, int wt){
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    static class Dhelper{
        int src;
        int wsf;
        //String psf;

        Dhelper(int src, int wsf){
            this.src = src;
            this.wsf = wsf;
        }
    }

    static ArrayList<ArrayList<Edge>> graph;

    static int[] sortestDistanceFromSingleSourceToAllDestination(int src){
        return dijkstraAlgo(src);
    }

    private static int[] dijkstraAlgo(int src) {
        int n = graph.size();
        PriorityQueue<Dhelper> pq = new PriorityQueue<>(new Comparator<Dhelper>() {
            @Override
            public int compare(Dhelper o1, Dhelper o2) {
                return o1.wsf - o2.wsf;
            }
        });

        boolean[] vis = new boolean[n];
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        pq.add(new Dhelper(0, 0));

        while (!pq.isEmpty()){
            // remove
            Dhelper pair = pq.remove();
            // mark *
            if(vis[pair.src] == true)   continue;
            vis[pair.src] = true;
            // work
            ans[pair.src] = pair.wsf;
            // add unvisited nbr

            for (Edge e : graph.get(pair.src)){
                if (vis[e.nbr] == false){
                    pq.add(new Dhelper(e.nbr, e.wt+ pair.wsf));
                }
            }
        }
        return  ans;
    }


    public static void main(String[] args){}
}
