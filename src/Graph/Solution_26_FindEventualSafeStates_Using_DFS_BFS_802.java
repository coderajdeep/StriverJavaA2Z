package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution_26_FindEventualSafeStates_Using_DFS_BFS_802 {
    public List<Integer> eventualSafeNodesUsingDFS(int[][] graph) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        boolean[] path = new boolean[V];
        boolean[] cycle = new boolean[V];
        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                dfs(i, visited, path, cycle, graph);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<V; i++) {
            if (!cycle[i]) {
                result.add(i);
            }
        }
        return result;
    }
    private boolean dfs(int u, boolean[] visited, boolean[] path, boolean[] cycle, int[][] adj) {
        visited[u] = true;
        path[u] = true;
        cycle[u] = true;
        for (int v : adj[u]) {
            if (!visited[v]) {
                if (dfs(v, visited, path, cycle, adj)) {
                    return true;
                }
            }
            else if (path[v]) {
                return true;
            }
        }
        path[u] = false;
        cycle[u] = false;
        return false;
    }


    public List<Integer> eventualSafeNodesUsingBFS(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> newGraph = new ArrayList<> ();
        for (int u=0; u<V; u++) {
            newGraph.add(new ArrayList<> ());
        }
        int[] indegree = new int[V];
        for (int u=0; u<V; u++) {
            for (int v : graph[u]) {
                newGraph.get(v).add(u);
                indegree[u]++;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i=0; i<V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> result = new ArrayList<> ();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            result.add(u);
            for (int v : newGraph.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        result.sort((a, b) -> a - b);
        return result;
    }
}
