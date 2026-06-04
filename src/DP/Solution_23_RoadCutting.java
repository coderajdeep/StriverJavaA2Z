package DP;

import java.util.Arrays;

public class Solution_23_RoadCutting {

    // Best Solution
    // Time complexity O(n*target)
    // Space complexity O(target) 1D array
    // Tabulation (Bottom up)
    public int RodCuttingBestSolution(int[] prices, int n) {
        int[] dp = new int[n+1];
        for (int i=0; i<=n; i++) {
            dp[i] = (i * prices[0]);
        }
        for (int i=1; i<n; i++) {
            for (int j=0; j<=n; j++) {
                int take = ((i+1) <= j) ? prices[i] + dp[j-(i+1)] : Integer.MIN_VALUE;
                int notTake = dp[j];
                dp[j] = Math.max(take, notTake);
            }
        }
        return dp[n];
    }

    // Time complexity O(n*target)
    // Space complexity O(n*target) 2D array
    // Tabulation (Bottom up)
    public int RodCuttingTabulation(int[] prices, int n) {
        int[][] dp = new int[n][n+1];
        for (int i=0; i<=n; i++) {
            dp[0][i] = (i * prices[0]);
        }
        for (int i=1; i<n; i++) {
            for (int j=0; j<=n; j++) {
                int take = ((i+1) <= j) ? prices[i] + dp[i][j-(i+1)] : Integer.MIN_VALUE;
                int notTake = dp[i-1][j];
                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[n-1][n];
    }

    // Time complexity O(n*target)
    // Space complexity O(n*target) 2D array
    // Memoization (Top down)
    public int RodCuttingMemoization(int[] prices, int n) {
        int[][] dp = new int[n][n+1];
        fill(n, dp);
        return getMax(n-1, n, prices, dp);
    }
    private int getMax(int index, int length, int[] prices, int[][] dp) {
        if (index == 0) {
            return prices[0] * length;
        }
        if (dp[index][length] != -1) {
            return dp[index][length];
        }
        int take = Integer.MIN_VALUE;
        if ((index+1) <= length) {
            take = prices[index] + getMax(index, length - (index+1), prices, dp);
        }
        int notTake = getMax(index-1, length, prices, dp);
        return dp[index][length] = Math.max(take, notTake);
    }
    private void fill(int n, int[][] dp) {
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
    }
}
