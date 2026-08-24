package __14__DP;

import java.util.Arrays;

public class Solution_09_UniquePathsII_63 {


    // Best Solution
    // Time complexity O(n*m)
    // Space complexity O(m) 1D array
    public int uniquePathsWithObstaclesBestSolution(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (matrix[0][0] == 1 || matrix[n-1][m-1] == 1) {
            return 0;
        }
        int[] dp = new int[m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (matrix[i][j] == 1) {
                    dp[j] = 0;
                }
                else if (i==0 && j==0) {
                    dp[j] = 1;
                }
                else {
                    int up = i==0 ? 0 : dp[j];
                    int left = j==0 ? 0 : dp[j-1];
                    dp[j] = up + left;
                }
            }
        }
        return dp[m-1];
    }

    // Time complexity O(n*m)
    // Space complexity O(n*m) 2D array
    // Tabulation (Bottom up)
    public int uniquePathsWithObstaclesTabulation(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (matrix[0][0] == 1 || matrix[n-1][m-1] == 1) {
            return 0;
        }
        int[][] dp = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 0;
                }
                else if (i==0 && j==0) {
                    dp[i][j] = 1;
                }
                else {
                    int up = i==0 ? 0 : dp[i-1][j];
                    int left = j==0 ? 0 : dp[i][j-1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[n-1][m-1];
    }

    // Time complexity O(n*m) -> 2D array + Recursion function call stack
    // Space complexity O(n*m) Recursion stack space
    // Memoization (Top down)
    public int uniquePathsWithObstaclesMemoization(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (matrix[0][0] == 1 || matrix[n-1][m-1] == 1) {
            return 0;
        }
        int[][] dp = new int[n][m];
        fill(n, dp);
        return getCountTabulation(n-1, m-1, matrix, dp);
    }
    private int getCountTabulation(int i, int j, int[][] matrix, int[][] dp) {
        if (i < 0 || j < 0 || matrix[i][j] == 1) {
            return 0;
        }
        if (i == 0 && j == 0 && matrix[i][j] == 0) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int left = getCountTabulation(i, j-1, matrix, dp);
        int up = getCountTabulation(i-1, j, matrix, dp);
        return dp[i][j] = left + up;
    }
    private void fill(int n, int[][] dp) {
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
    }
}
