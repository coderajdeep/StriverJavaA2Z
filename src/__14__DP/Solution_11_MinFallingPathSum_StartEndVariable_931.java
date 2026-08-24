package __14__DP;

import java.util.Arrays;

public class Solution_11_MinFallingPathSum_StartEndVariable_931 {

    // Best Solution
    // Time complexity O(n*m)
    // Space complexity O(m) 1D array
    public int minFallingPathSumBottomFixedBestSolution(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] prev = new int[m];
        int[] curr = new int[m];
        System.arraycopy(matrix[0], 0, prev, 0, m);
        for (int i=1; i<n; i++) {
            for (int j=0; j<m; j++) {
                int up = prev[j];
                int upLeft = (j==0) ? Integer.MAX_VALUE : prev[j-1];
                int upRight = (j==m-1) ? Integer.MAX_VALUE : prev[j+1];
                curr[j] = matrix[i][j] + Math.min(up, Math.min(upLeft, upRight));
            }
            System.arraycopy(curr, 0, prev, 0, m);
        }
        int minValue = Integer.MAX_VALUE;
        for (int i=0; i<m; i++) {
            minValue = Math.min(minValue, prev[i]);
        }
        return minValue;
    }

    // Time complexity O(n*m)
    // Space complexity O(m) 1D array
    // Tabulation (Bottom up)
    public int minFallingPathSumTopFixedBestSolution(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] prev = new int[m];
        int[] curr = new int[m];
        System.arraycopy(matrix[n-1], 0, prev, 0, m);
        for(int i=n-2; i>=0; i--) {
            for (int j=0; j<m; j++) {
                int down = prev[j];
                int right = (j != m-1) ? prev[j+1] : Integer.MAX_VALUE;
                int left = (j != 0) ? prev[j-1] : Integer.MAX_VALUE;
                curr[j] = matrix[i][j] + Math.min(left, Math.min(down, right));
            }
            System.arraycopy(curr, 0, prev, 0, m);
        }
        int minValue = Integer.MAX_VALUE;
        for (int value : prev) {
            minValue = Math.min(value, minValue);
        }
        return minValue;
    }

    // Time complexity O(n*m)
    // Space complexity O(n*m) 2D array
    // Tabulation (Bottom up)
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        fillTabulation(n, dp);
        System.arraycopy(matrix[0], 0, dp[0], 0, m);
        for (int i=1; i<n; i++) {
            for (int j=0; j<m; j++) {
                int up = dp[i-1][j];
                int upLeft = (j==0) ? Integer.MAX_VALUE : dp[i-1][j-1];
                int upRight = (j==m-1) ? Integer.MAX_VALUE : dp[i-1][j+1];
                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(upLeft, upRight));
            }
        }
        int minValue = Integer.MAX_VALUE;
        for (int i=0; i<m; i++) {
            minValue = Math.min(minValue, dp[n-1][i]);
        }
        return minValue;
    }

    private void fillTabulation(int n, int[][] dp) {
        for (int i=0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
    }

    // Time complexity O(n*m)
    // Space complexity O(n*m) 2D array + Recursion function call stack O(n)
    // Memoization (Top down)
    // Bottom Fixed
    // Start from all bottom paths
    // Starts from (n-1, i) : i = 0 to m-1
    // Ends at first row
    public int minFallingPathSumMemoization(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        fillMemoization(n, dp);
        int minValue = Integer.MAX_VALUE;
        for (int i=0; i<m; i++) {
            minValue = Math.min(minValue, getMinPathSum(n-1, i, m, matrix, dp));
        }
        return minValue;
    }
    private int getMinPathSum(int i, int j, int m, int[][] matrix, int[][] dp) {
        if (i==0) {
            return matrix[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int up = getMinPathSum(i-1, j, m, matrix, dp);
        int upLeft = (j == 0) ? Integer.MAX_VALUE : getMinPathSum(i-1, j-1, m, matrix, dp);
        int upRight = (j == m-1) ? Integer.MAX_VALUE : getMinPathSum(i-1, j+1, m, matrix, dp);
        return dp[i][j] = matrix[i][j] + Math.min(up, Math.min(upLeft, upRight));
    }
    private void fillMemoization(int n, int[][] dp) {
        for (int i=0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
    }
}
