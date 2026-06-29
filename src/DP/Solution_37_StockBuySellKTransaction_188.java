package DP;

// This is similar to Solution_36_StockBySellWithTwoTransaction_123
public class Solution_37_StockBuySellKTransaction_188 {
    // Time complexity O(n*transactionLimit*2)
    // Space complexity O(transactionLimit*2)
    public int stockBuySell(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][k+1][2];
        for (int i=n-1; i>=0; i--) {
            for (int j=1; j<=k; j++) {
                // buy allowed
                int buy = dp[i+1][j][0] - prices[i];
                int notBuy = dp[i+1][j][1];
                dp[i][j][1] = Math.max(buy, notBuy);

                // sell allowed
                int sell = dp[i+1][j-1][1] + prices[i];
                int notSell = dp[i+1][j][0];
                dp[i][j][0] = Math.max(sell, notSell);
            }
        }
        return dp[0][k][1];
    }
}
