package Graph;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Solution_23_DetectCycleInDirectedGraph_BFS {
    public boolean isCyclic(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];
        for (int u=0; u<V; u++) {
            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int u=0; u<V; u++) {
            if (indegree[u] == 0) {
                queue.offer(u);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            count++;
            for (int v : adj.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return (count < V);
    }
}
