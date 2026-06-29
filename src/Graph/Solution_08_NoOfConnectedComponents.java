package Graph;

import java.util.ArrayList;
import java.util.List;

public class Solution_08_NoOfConnectedComponents {
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        List<List<Integer>> graph = buildGraph(V, edges);
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
