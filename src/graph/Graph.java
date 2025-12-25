package graph;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Graph {
    int vtx;
    ArrayList<ArrayList<Integer>> adjList;

    Graph(int vtx){
        this.vtx = vtx;
        adjList = new ArrayList<>(vtx);



    }


}
