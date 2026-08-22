package Graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution_22_TopologicalSort_BFS {
    // Note: despite the filename/BFS naming, this is a DFS + stack implementation (same approach
    // as Solution_21_TopologicalSort_DFS), not Kahn's algorithm (in-degree + BFS queue).
    public int[] topoSort(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, adj);
            }
        }
        int size = stack.size();
        int[] result = new int[size];
        for (int i=0; i<size && !stack.isEmpty(); i++) {
            result[i] = stack.pop();
        }
        return result;
    }
    private void dfs(int u, boolean[] visited, Deque<Integer> stack, List<List<Integer>> adj) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, visited, stack, adj);
            }
        }
        stack.push(u);
    }
}
