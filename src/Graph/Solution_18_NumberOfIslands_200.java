package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_18_NumberOfIslands_200 {
    // Time complexity O(n*m)
    // Space complexity O(n*m)
    // left, up, right, down, left up, right up, right down, left down
    private static final int[] dx = {0, -1, 0, 1, -1, -1, 1, 1};
    private static final int[] dy = {-1, 0, 1, 0, -1, 1, 1, -1};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    // We can use dfs or bfs
                    bfs(i, j, n, m, visited, grid);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(int i, int j, int n, int m, boolean[][] visited, char[][] grid) {
        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;
        for (int index=0; index<dx.length; index++) {
            dfs(i + dx[index], j + dy[index], n, m, visited, grid);
        }
    }
    private void bfs(int i, int j, int n, int m, boolean[][] visited, char[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            for (int index=0; index<dx.length; index++) {
                int a = x + dx[index];
                int b = y + dy[index];
                if (a >= 0 && a < n && b >= 0 && b < m && !visited[a][b] && grid[a][b] == '1') {
                    queue.offer(new int[] {a, b});
                    visited[a][b] = true;
                }
            }
        }
    }
}
