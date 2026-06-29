package Graph;

import java.util.List;

public class Solution_20_DetectCycleInDirectedGraph_DFS {
    public boolean isCyclic(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] path = new boolean[V];
        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, path, adj)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int u, boolean[] visited, boolean[] path, List<List<Integer>> adj) {
        visited[u] = true;
        path[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                if (dfs(v, visited, path, adj)) {
                    return true;
                }
            }
            else if (path[v]) {
                return true;
            }
        }
        path[u] = false;
        return false;
    }
}
