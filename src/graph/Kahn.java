package graph;

import java.util.*;

/*
Kahn's algorithm is an efficient method for performing topological sorting
on a Directed Acyclic Graph (DAG)
 */

public class Kahn {
    // Directed Graph class (reuse from previous, but ensure directed: no symmetric add)
    static class DirectedGraph {
        private final int vertices;
        private final List<List<Integer>> adjList;

        public DirectedGraph(int v) {
            vertices = v;
            adjList = new ArrayList<>(v);
            for (int i = 0; i < v; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v) {
            adjList.get(u).add(v);  // Directed: only u -> v
        }
    }

    public static List<Integer> topologicalSort(DirectedGraph graph) {
        int V = graph.vertices;
        int[] indegree = new int[V];

        // Step 1: Compute indegrees
        for (int u = 0; u < V; u++) {
            for (int v : graph.adjList.get(u)) {
                indegree[v]++;
            }
        }

        // Step 2: Queue for indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 3: Process
        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.add(u);

            // Step 4: Reduce neighbors' indegrees
            for (int v : graph.adjList.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        // Step 5: Cycle check
        if (order.size() != V) {
            System.out.println("Graph contains a cycle! Cannot perform topological sort.");
            return new ArrayList<>();  // Empty or handle error
        }

        return order;
    }

    public static void main(String[] args) {
        // Example DAG: 0 -> 1 -> 2, 0 -> 3
        DirectedGraph g = new DirectedGraph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(0, 3);

        List<Integer> order = topologicalSort(g);
        System.out.println("Topological Order: " + order);
        // Output: [0, 1, 3, 2] or [0, 3, 1, 2] (non-unique)

        // Example with cycle: Add 2 -> 0
        DirectedGraph gCycle = new DirectedGraph(3);
        gCycle.addEdge(0, 1);
        gCycle.addEdge(1, 2);
        gCycle.addEdge(2, 0);  // Cycle
        List<Integer> orderCycle = topologicalSort(gCycle);
        // Output: "Graph contains a cycle!" and empty list
    }
}

