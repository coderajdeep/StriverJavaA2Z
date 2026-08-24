package __14__DP;

public class Solution_35_StockBuySellMultipleTransaction_122 {
    // Time complexity O(n)
    // Space complexity O(1)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        for (int i=1; i<n; i++) {
            if (prices[i-1] < prices[i]) {
                maxProfit += (prices[i] - prices[i-1]);
            }
        }
        return maxProfit;
    }
}
