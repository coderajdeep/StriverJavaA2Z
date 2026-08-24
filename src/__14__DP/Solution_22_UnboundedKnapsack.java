package __14__DP;

import java.util.Arrays;

public class Solution_22_UnboundedKnapsack {

    // Best Solution
    // Time complexity O(n*W)
    // Space complexity O(W) 1D array
    // Tabulation (Bottom up)
    public int unboundedKnapsackBestSolution(int[] wt, int[] val, int n, int W) {
        int[] dp = new int[W+1];
        for (int i=0; i<=W; i++) {
            if (wt[0] <= i) {
                dp[i] = (i / wt[0]) * val[0];
            }
        }
        for (int i=1; i<n; i++) {
            for (int j=0; j<=W; j++) {
                int take = (wt[i] <= j) ? val[i] + dp[j-wt[i]] : 0;
                int notTake = dp[j];
                dp[j] = Math.max(take, notTake);
            }
        }
        return dp[W];
    }

    // Time complexity O(n*W)
    // Space complexity O(n*W) 2D array
    // Tabulation (Bottom up)
    public int unboundedKnapsackTabulation(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n][W+1];
        for (int i=0; i<=W; i++) {
            if (wt[0] <= i) {
                dp[0][i] = (i / wt[0]) * val[0];
            }
        }
        for (int i=1; i<n; i++) {
            for (int j=0; j<=W; j++) {
                int take = (wt[i] <= j) ? val[i] + dp[i][j-wt[i]] : 0;
                int notTake = dp[i-1][j];
                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[n-1][W];
    }

    // Time complexity O(n*W)
    // Space complexity O(n*W) 2D array + Recursion function call stack O(n)
    // Memoization (Top down)
    public int unboundedKnapsackMemoization(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n][W+1];
        fill(n, dp);
        return getMax(n-1, W, wt, val, dp);
    }
    private int getMax(int index, int w, int[] wt, int[] val, int[][] dp) {
        if (index == 0) {
            return (w / wt[0]) * val[0];
        }
        if (dp[index][w] != -1) {
            return dp[index][w];
        }
        int take = 0;
        if (wt[index] <= w) {
            take = val[index] + getMax(index, w - wt[index], wt, val, dp);
        }
        int notTake = getMax(index - 1, w, wt, val, dp);
        return dp[index][w] = Math.max(take, notTake);
    }
    private void fill(int n, int[][] dp) {
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
    }
}
