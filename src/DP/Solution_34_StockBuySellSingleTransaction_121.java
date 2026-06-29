package DP;

public class Solution_34_StockBuySellSingleTransaction_121 {
    // Time complexity O(n)
    // Space complexity O(1)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minStockValue = prices[0];
        int maxProfit = 0;
        for (int i=1; i<n; i++) {
            int profit = prices[i] - minStockValue;
            maxProfit = Math.max(maxProfit, profit);
            minStockValue = Math.min(minStockValue, prices[i]);
        }
        return maxProfit;
    }
}
