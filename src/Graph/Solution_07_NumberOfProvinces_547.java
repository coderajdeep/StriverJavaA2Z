package Graph;

import java.util.ArrayList;
import java.util.List;

public class Solution_07_NumberOfProvinces_547 {
    public int numProvinces(int[][] adj) {
        int V = adj.length;
        List<List<Integer>> graph = buildGraph(adj);
        int count = 0;
        boolean[] visited = new boolean[V];
        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, visited, graph);
            }
        }
        return count;
    }
    private void dfs(int u, boolean[] visited, List<List<Integer>> graph) {
        visited[u] = true;
        for (int v : graph.get(u)) {
            if (!visited[v]) {
                dfs(v, visited, graph);
            }
        }
    }
    private List<List<Integer>> buildGraph(int[][] adj) {
        int V = adj.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<V; i++) {
            graph.add(new ArrayList<> ());
        }
        for (int i=0; i<V; i++) {
            for (int j=0; j<V; j++) {
                if (adj[i][j] == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        return graph;
    }
}
