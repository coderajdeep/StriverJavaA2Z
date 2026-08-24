package __13__Graph;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Solution_11_DetectCycle_BFS_DFS {
    // Time complexity O(V + E)
    // Space complexity O(V + E)
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                if (isCycleDFS(i, -1, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isCycleBFS(int source, int parent, boolean[] visited, List<Integer>[] adj) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {source, parent});
        visited[source] = true;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int u = node[0];
            int p = node[1];
            for (int v : adj[u]) {
                if (!visited[v]) {
                    queue.offer(new int[] {v, u});
                    visited[v] = true;
                }
                else if (visited[v] && v != p) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isCycleDFS(int source, int parent, boolean[] visited, List<Integer>[] adj) {
        visited[source] = true;
        for (int u : adj[source]) {
            if (!visited[u]) {
                if (isCycleDFS(u, source, visited, adj)) {
                    return true;
                }
            }
            else if (u != parent) {
                return true;
            }
        }
        return false;
    }
}
