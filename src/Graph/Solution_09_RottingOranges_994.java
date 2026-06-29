package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_09_RottingOranges_994 {

    // Time complexity O(n*m)
    // Space complexity O(n*m)
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int freshCount = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
                else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;
            for (int i=0; i<size; i++) {
                int[] node = queue.poll();
                int x = node[0];
                int y = node[1];
                for (int j=0; j<4; j++) {
                    int a = x + dx[j];
                    int b = y + dy[j];
                    if (a >= 0 && a < n && b >= 0 && b < m && grid[a][b] == 1) {
                        queue.offer(new int[] {a, b});
                        grid[a][b] = 2;
                        freshCount--;
                        flag = true;
                    }
                }
            }
            if (flag) {
                time++;
            }
        }
        return freshCount == 0 ? time : -1;
    }
}
