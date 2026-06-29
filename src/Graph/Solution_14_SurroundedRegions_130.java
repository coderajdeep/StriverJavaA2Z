package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_14_SurroundedRegions_130 {
    // Time complexity O(n*m)
    // Space complexity O(n*m)
    public char[][] fill(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i=0; i<n; i++) {
            if (mat[i][0] == 'O') {
                queue.offer(new int[] {i, 0});
                mat[i][0] = 'V';
            }
            if (mat[i][m-1] == 'O') {
                queue.offer(new int[] {i, m-1});
                mat[i][m-1] = 'V';
            }
        }
        for (int i=0; i<m; i++) {
            if (mat[0][i] == 'O') {
                queue.offer(new int[] {0, i});
                mat[0][i] = 'V';
            }
            if (mat[n-1][i] == 'O') {
                queue.offer(new int[] {n-1, i});
                mat[n-1][i] = 'V';
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
                if (a >= 0 && a < n && b >= 0 && b < m && mat[a][b] == 'O') {
                    queue.offer(new int[] {a, b});
                    mat[a][b] = 'V';
                }
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (mat[i][j] == 'V') {
                    mat[i][j] = 'O';
                }
                else {
                    mat[i][j] = 'X';
                }
            }
        }
        return mat;
    }
}
