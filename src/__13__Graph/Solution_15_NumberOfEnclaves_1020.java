package __13__Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_15_NumberOfEnclaves_1020 {
    // Time complexity O(n*m)
    // Space complexity O(n*m)
    public int numEnclaves(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i=0; i<n; i++) {
            if (mat[i][0] == 1) {
                queue.offer(new int[] {i, 0});
                mat[i][0] = 2;
            }
            if (mat[i][m-1] == 1) {
                queue.offer(new int[] {i, m-1});
                mat[i][m-1] = 2;
            }
        }
        for (int i=0; i<m; i++) {
            if (mat[0][i] == 1) {
                queue.offer(new int[] {0, i});
                mat[0][i] = 2;
            }
            if (mat[n-1][i] == 1) {
                queue.offer(new int[] {n-1, i});
                mat[n-1][i] = 2;
            }
        }
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            for (int i=0; i<4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];
                if (a >= 0 && a < n && b >= 0 && b < m && mat[a][b] == 1) {
                    queue.offer(new int[] {a, b});
                    mat[a][b] = 2;
                }
            }
        }
        int count = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (mat[i][j] == 2) {
                    mat[i][j] = 1;
                }
                else if (mat[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
