package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_10_FloodFill_733 {
    // Time complexity O(n*m)
    // Space complexity O(n*m)
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        int n = image.length;
        int m = image[0].length;
        int prevColor = image[sr][sc];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sr, sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            for (int i=0; i<4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];
                if (a >= 0 && a < n && b >= 0 && b < m && image[a][b] == prevColor) {
                    queue.offer(new int[] {a, b});
                    image[a][b] = newColor;
                }
            }
        }
        return image;
    }
}
