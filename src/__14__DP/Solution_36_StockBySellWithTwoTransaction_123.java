package __14__DP;

import java.util.Arrays;

public class Solution_36_StockBySellWithTwoTransaction_123 {

    // Time Complexity O(n*transactionLimit*2)
    // Space Complexity O(transactionLimit*2)
    // Best Approach
    public int maxProfitBestApproach(int[] prices) {
        return getMaxProfitBestApproach(prices, 2);
    }

    private int getMaxProfitBestApproach(int[] prices, int tranLimit) {
        int n = prices.length;

        int[][] next = new int[tranLimit + 1][2];
        int[][] curr = new int[tranLimit + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= tranLimit; j++) {

                // Option 1: Buy stock on current day
                int buy = next[j][0] - prices[i];

                // Option 2: Skip buying
                int notBuy = next[j][1];

                curr[j][1] = Math.max(buy, notBuy);

                // Option 1: Sell stock on current day
                int sell = next[j - 1][1] + prices[i];

                // Option 2: Skip selling
                int notSell = next[j][0];

                curr[j][0] = Math.max(sell, notSell);
            }
            for (int j = 1; j <= tranLimit; j++) {
                System.arraycopy(curr[j], 0, next[j], 0, 2);
            }
        }

        return curr[tranLimit][1];
    }


    // Time complexity O(n*transactionLimit*2)
    // Space complexity O(n*transactionLimit*2)
    // Tabulation (Bottom up)
    public int maxProfitTabulation(int[] prices) {
        return getMaxProfitTabulation(prices, 2);
    }

    private int getMaxProfitTabulation(int[] prices, int tranLimit) {
        int n = prices.length;

        // dp[i][j][buy]
        // i    -> current day index
        // j    -> remaining transactions
        // buy  -> 1 means buying is allowed
        //         0 means selling is allowed (stock already bought)
        //
        // dp[i][j][buy] stores the maximum profit that can be earned
        // starting from day i with j transactions remaining
        // and current buy/sell state.
        //
        // Base Case:
        // dp[n][*][*] = 0 -> No days left
        // dp[*][0][*] = 0 -> No transactions left
        //
        // Java initializes arrays with 0 by default.

        int[][][] dp = new int[n + 1][tranLimit + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= tranLimit; j++) {

                // Option 1: Buy stock on current day
                int buy = dp[i + 1][j][0] - prices[i];

                // Option 2: Skip buying
                int notBuy = dp[i + 1][j][1];

                dp[i][j][1] = Math.max(buy, notBuy);

                // Option 1: Sell stock on current day
                int sell = dp[i + 1][j - 1][1] + prices[i];

                // Option 2: Skip selling
                int notSell = dp[i + 1][j][0];

                dp[i][j][0] = Math.max(sell, notSell);
            }
        }

        return dp[0][tranLimit][1];
    }


    // Time complexity O(n*3*2)
    // Space complexity O(n*3*2)
    // Memoization (Top down)
    public int maxProfitMemoization(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][3][2];
        fill(n, 3, dp);
        return getMaxProfit(0, 1, 2, prices, dp);
    }
    private int getMaxProfit(int dayIndex, int buyAllowed, int transaction, int[] prices, int[][][] dp) {
        if (dayIndex == prices.length || transaction == 0) {
            return 0;
        }
        int maxProfit = Integer.MIN_VALUE;
        if (buyAllowed == 1) {
            int buy = getMaxProfit(dayIndex + 1, 0, transaction, prices, dp) - prices[dayIndex];
            int notBuy = getMaxProfit(dayIndex + 1, 1, transaction, prices, dp);
            maxProfit = Math.max(buy, notBuy);
        }
        else {
            int sell = getMaxProfit(dayIndex + 1, 1, transaction - 1, prices, dp) + prices[dayIndex];
            int notSell = getMaxProfit(dayIndex + 1, 0, transaction, prices, dp);
            maxProfit = Math.max(sell, notSell);
        }
        return dp[dayIndex][transaction][buyAllowed] = maxProfit;
    }
    private void fill(int n, int m, int[][][] dp) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
    }
}
