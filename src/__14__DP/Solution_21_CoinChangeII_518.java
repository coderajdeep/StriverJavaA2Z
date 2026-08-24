package __14__DP;

import java.util.Arrays;

public class Solution_21_CoinChangeII_518 {

    // Best Solution
    // Time complexity O(n*target)
    // Space complexity O(target) 1D array
    // Tabulation (Bottom up)
    public int changeBestSolution(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        for (int i=0; i<=amount; i++) {
            dp[i] = (i % coins[0] == 0) ? 1 : 0;
        }
        for (int i=1; i<n; i++) {
            for (int j=0; j<=amount; j++) {
                int take = 0;
                if (coins[i] <= j) {
                    take = dp[j-coins[i]];
                }
                int notTake = dp[j];
                dp[j] = take + notTake;
            }
        }
        return dp[amount];
    }

    // Time complexity O(n*target)
    // Space complexity O(n*target) 2D array
    // Tabulation (Bottom up)
    public int changeTabulation(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for (int i=0; i<=amount; i++) {
            dp[0][i] = (i % coins[0] == 0) ? 1 : 0;
        }
        for (int i=1; i<n; i++) {
            for (int j=0; j<=amount; j++) {
                int take = 0;
                if (coins[i] <= j) {
                    take = dp[i][j-coins[i]];
                }
                int notTake = dp[i-1][j];
                dp[i][j] = take + notTake;
            }
        }
        return dp[n-1][amount];
    }

    // Time complexity O(n*target)
    // Space complexity O(n*target) 2D array + Recursion function call stack O(n)
    // Memoization (Top down)
    public int changeMemoization(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        fill(n, dp);
        return getCount(n-1, amount, coins, dp);
    }
    private int getCount(int index, int amount, int[] coins, int[][] dp) {
        if (index == 0) {
            return amount % coins[0] == 0 ? 1 : 0;
        }
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }
        int take = 0;
        if (coins[index] <= amount) {
            take = getCount(index, amount - coins[index], coins, dp);
        }
        int notTake = getCount(index - 1, amount, coins, dp);
        return dp[index][amount] = (take + notTake);
    }
    private void fill(int n, int[][] dp) {
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
    }
}
