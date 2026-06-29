package Array;

public class Solution_20_StockBuyAndSell_121 {
    // Time complexity O(n)
    // Space complexity O(1)
    public int stockBuySell(int[] arr, int n) {
        int minStockValue = arr[0];
        int maxProfit = 0;
        for (int i=1; i<n; i++) {
            int profit = arr[i] - minStockValue;
            maxProfit = Math.max(maxProfit, profit);
            minStockValue = Math.min(minStockValue, arr[i]);
        }
        return maxProfit;
    }
}
