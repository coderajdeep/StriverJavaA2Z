package Graph;

import java.util.*;

public class Solution_19_BipartiteGraph_785 {
    public boolean isBipartite(int V, List<List<Integer>> edges) {
        List<List<Integer>> graph = buildGraph(V, edges);
        int[] visited = new int[V];
        Arrays.fill(visited, -1);
        for (int i=0; i<V; i++) {
            if (visited[i] == -1) {
                if (!bfs(i, 0, visited, graph)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int u, int color, int[] visited, List<List<Integer>> graph) {
        visited[u] = color;
        for (int v : graph.get(u)) {
            if (visited[v] == -1) {
                int nextColor = color == 1 ? 0 : 1;
                if (!dfs(v, nextColor, visited, graph)) {
                    return false;
                }
            }
            else if (visited[v] == color) {
                return false;
            }
        }
        return true;
    }
    private boolean bfs(int source, int color, int[] visited, List<List<Integer>> graph) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {source, color});
        visited[source] = color;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int u = node[0];
            int clr = node[1];
            int nextColor = clr == 1 ? 0 : 1;
            for (int v : graph.get(u)) {
                if (visited[v] == -1) {
                    queue.offer(new int[] {v, nextColor});
                    visited[v] = nextColor;
                }
                else if (visited[v] == clr) {
                    return false;
                }
            }
        }
        return true;
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
