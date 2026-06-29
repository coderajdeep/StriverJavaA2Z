package Graph;

import java.util.*;

public class Solution_05_GraphBfsAndDfs {
    // Time complexity O(V + E)
    // Space complexity O(V + E)
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> edges) {
        List<List<Integer>> graph = buildGraph(V, edges);
        List<Integer> result = new ArrayList<> ();
        boolean[] visited = new boolean[V];
        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                dfs(i, visited, graph, result);
            }
        }
        return result;
    }

    private void dfs(int u, boolean[] visited, List<List<Integer>> graph, List<Integer> result) {
        result.add(u);
        visited[u] = true;
        for (int v : graph.get(u)) {
            if (!visited[v]) {
                dfs(v, visited, graph, result);
            }
        }
    }

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> edges) {
        List<List<Integer>> graph = buildGraph(V, edges);
        List<Integer> result = new ArrayList<> ();
        boolean[] visited = new boolean[V];
        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                bfs(i, visited, graph, result);
            }
        }
        return result;
    }

    private void bfs(int source, boolean[] visited, List<List<Integer>> graph, List<Integer> result) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            result.add(u);
            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    queue.offer(v);
                    visited[v] = true;
                }
            }
        }
    }

    private List<List<Integer>> buildGraph(int V, List<List<Integer>> edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<V; i++) {
            graph.add(new ArrayList<> ());
        }
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
}
