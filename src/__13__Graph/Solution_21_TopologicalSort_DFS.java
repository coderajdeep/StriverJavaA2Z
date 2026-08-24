package __13__Graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution_21_TopologicalSort_DFS {
    public int[] topoSort(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, adj);
            }
        }
        int size = stack.size(), index = 0;
        int[] result = new int[size];
        while (!stack.isEmpty()) {
            result[index++] = stack.pop();
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
