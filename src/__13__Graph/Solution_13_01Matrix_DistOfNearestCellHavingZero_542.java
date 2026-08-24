package __13__Graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution_13_01Matrix_DistOfNearestCellHavingZero_542 {
    // Time complexity O(n*m)
    // Space complexity O(n*m)
    public int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] result = new int[n][m];
        for (int i=0; i<n; i++) {
            Arrays.fill(result[i], -1);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 0) {
                    result[i][j] = 0;
                    queue.offer(new int[] {i, j, 0});
                }
            }
        }
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            int dist = node[2];
            for (int i=0; i<4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];
                if (a >= 0 && a < n && b >= 0 && b < m && result[a][b] == -1) {
                    queue.offer(new int[] {a, b, dist + 1});
                    result[a][b] = dist + 1;
                }
            }
        }
        return result;
    }
}
