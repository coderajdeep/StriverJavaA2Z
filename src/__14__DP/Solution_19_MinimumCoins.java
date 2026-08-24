package __14__DP;

import java.util.Arrays;

public class Solution_19_MinimumCoins {

    // Best Solution
    // Time complexity O(n*target)
    // Space complexity O(target) 1D array
    // Tabulation (Bottom up)
    public int MinimumCoinsBestSolution(int[] coins, int target) {
        int n = coins.length;
        int[] dp = new int[target+1];
        for (int i=0; i<=target; i++) {
            if (i % coins[0] == 0) {
                dp[i] = (i / coins[0]);
            }
            else {
                dp[i] = Integer.MAX_VALUE;
            }
        }
        for (int i=1; i<n; i++) {
            for (int j=0; j<=target; j++) {
                int take = Integer.MAX_VALUE;
                if ((coins[i] <= j) && dp[j-coins[i]] != Integer.MAX_VALUE) {
                    take = 1 + dp[j-coins[i]];
                }
                int notTake = dp[j];
                dp[j] = Math.min(take, notTake);
            }
        }
        return dp[target] == Integer.MAX_VALUE ? -1 : dp[target];
    }

    // Time complexity O(n*target)
    // Space complexity O(n*target) 2D array
    // Tabulation (Bottom up)
    public int MinimumCoinsTabulation(int[] coins, int target) {
        int n = coins.length;
        int[][] dp = new int[n][target+1];
        for (int i=0; i<=target; i++) {
            // Initialize first row:
            // If target is divisible by coins[0], it can be formed using only coins[0].
            // Otherwise mark it as unreachable with a very large value.
            if (i % coins[0] == 0) {
                dp[0][i] = (i / coins[0]);
            }
            else {
                // We need to mark this
                // Otherwise default value is 0 which is wrong
                dp[0][i] = Integer.MAX_VALUE;
            }
        }
        for (int i=1; i<n; i++) {
            for (int j=0; j<=target; j++) {
                int take = Integer.MAX_VALUE;
                if (coins[i] <= j && dp[i][j-coins[i]] != Integer.MAX_VALUE) {
                    take = 1 + dp[i][j-coins[i]];
                }
                int notTake = dp[i-1][j];
                dp[i][j] = Math.min(take, notTake);
            }
        }
        return dp[n-1][target] == Integer.MAX_VALUE ? -1 : dp[n-1][target];
    }

    // Time complexity O(n*target)
    // Space complexity O(n*target) 2D array + Recursion function call stack O(n)
    // Memoization (Top down)
    public int MinimumCoinsMemoization(int[] coins, int target) {
        int n = coins.length;
        int[][] dp = new int[n][target+1];
        fill(n, dp);
        getMinCoin(n-1, target, coins, dp);
        if (dp[n-1][target] == Integer.MAX_VALUE) {
            return -1;
        }
        else {
            return dp[n-1][target];
        }
    }
    private int getMinCoin(int index, int target, int[] coins, int[][] dp) {
        if (index == 0) {
            if (target % coins[0] == 0) {
                return dp[index][target] = target / coins[0];
            }
            else {
                return dp[index][target] = Integer.MAX_VALUE;
            }
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        int take = Integer.MAX_VALUE;
        if (coins[index] <= target) {
            int value = getMinCoin(index, target - coins[index], coins, dp);
            if (value != Integer.MAX_VALUE) {
                take = 1 + value;
            }
        }
        int notTake = getMinCoin(index-1, target, coins, dp);
        return dp[index][target] = Math.min(take, notTake);
    }
    private void fill(int n, int[][] dp) {
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
    }
}
