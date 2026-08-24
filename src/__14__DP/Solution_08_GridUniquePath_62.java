package __14__DP;

import java.util.Arrays;

public class Solution_08_GridUniquePath_62 {

    // Best Solution
    // Time complexity O(n*m) -> 1D array
    // Space complexity O(m) 1D array
    public int uniquePathsBestSolution(int n, int m) {
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for (int i=1; i<n; i++) {
            for (int j=1; j<m; j++) {
                int left = dp[j-1];
                int up = dp[j];
                dp[j] = left + up;
            }
        }
        return dp[m-1];
    }

    // Time complexity O(n*m) -> 2D array
    // Space complexity O(n*m) 2D array
    // Tabulation (Bottom up)
    public int uniquePathsTabulation(int n, int m) {
        int[][] dp = new int[n][m];
        Arrays.fill(dp[0], 1);
        for (int i=1; i<n; i++) {
            dp[i][0] = 1;
            for (int j=1; j<m; j++) {
                int left = dp[i][j-1];
                int up = dp[i-1][j];
                dp[i][j] = left + up;
            }
        }
        return dp[n-1][m-1];
    }

    // Time complexity O(n*m) -> 2D array + Recursion function call stack
    // Space complexity O(n*m) Recursion stack space
    // Memoization (Top down)
    public int uniquePathsMemoization(int n, int m) {
        int[][] dp = new int[n][m];
        fill(n, dp);
        return getCount(n-1, m-1, dp);
    }
    private int getCount(int i, int j, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (i == 0 || j == 0) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int up = getCount(i-1, j, dp);
        int left = getCount(i, j-1, dp);
        return dp[i][j] = up + left;
    }
    private void fill(int n, int[][] dp) {
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
    }
}
