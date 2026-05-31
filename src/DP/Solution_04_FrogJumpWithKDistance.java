package DP;

import java.util.Arrays;

public class Solution_04_FrogJumpWithKDistance {

    // Time complexity O(n*k)
    // Space complexity O(n) -> 1D array
    // Tabulation (Bottom up)
    public int frogJumpTabulation(int[] heights, int k) {
        int n = heights.length;
        if (n <= 1) {
            return 0;
        }
        int[] dp = new int[n];
        for(int i=1; i<n; i++) {
            int minValue = Integer.MAX_VALUE;
            for(int j=1; j<=k; j++) {
                if (i-j>=0) {
                    int value = dp[i-j] + Math.abs(heights[i] - heights[i-j]);
                    minValue = Math.min(minValue, value);
                }
                else {
                    break;
                }
            }
            dp[i] = minValue;
        }
        return dp[n-1];
    }

    // Time complexity O(n*k)
    // Space complexity O(n) -> 1D array + Recursion stack space
    // Memoization (Top down)
    public int frogJump(int[] heights, int k) {
        int n = heights.length;
        if (n <= 1) {
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return getMinEnergy(n-1, k, heights, dp);
    }
    private int getMinEnergy(int index, int k, int[] heights, int[] dp) {
        if (index == 0) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int minEnergyValue = Integer.MAX_VALUE;
        for (int i=1; i<=k; i++) {
            if (index-i >= 0) {
                int diff = Math.abs(heights[index] - heights[index-i]);
                int energyValue = getMinEnergy(index-i, k, heights, dp) + diff;
                minEnergyValue = Math.min(minEnergyValue, energyValue);
            }
            else {
                break;
            }
        }
        return dp[index] = minEnergyValue;
    }
}
