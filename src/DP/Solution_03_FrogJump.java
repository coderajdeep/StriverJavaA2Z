package DP;

import java.util.Arrays;

public class Solution_03_FrogJump {

    // Time complexity O(n)
    // Space complexity O(1)
    // Tabulation (Bottom up)
    // Space optimized
    public int frogJumpBestSolution(int[] heights) {
        int n = heights.length;
        if (n <= 1) {
            return 0;
        }
        int prev1 = Math.abs(heights[1] - heights[0]);
        if (n == 2) {
            return prev1;
        }
        int prev2 = 0, curr = 0;
        for (int i=2; i<n; i++) {
            int prevValue1 = prev1 + Math.abs(heights[i] - heights[i-1]);
            int prevValue2 = prev2 + Math.abs(heights[i] - heights[i-2]);
            curr = Math.min(prevValue1, prevValue2);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }

    // Time complexity O(n)
    // Space complexity O(n)
    // Tabulation (Bottom up)
    public int frogJumpTabulation(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        if (n == 1) {
            return dp[0];
        }
        dp[1] = Math.abs(heights[1] - heights[0]);
        for (int i=2; i<n; i++) {
            int prev1 = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
            int prev2 = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
            dp[i] = Math.min(prev1, prev2);
        }
        return dp[n-1];
    }


    // Time Complexity O(n)
    // Space Complexity O(2*n) -> 1D array + Recursion stack space
    // Memoization (Top down)
    public int frogJumpMemoization(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return getMinEnergy(n-1, heights, dp);
    }
    private int getMinEnergy(int index, int[] heights, int[] dp) {
        if (index == 0) {
            return 0;
        }
        if (index == 1) {
            return Math.abs(heights[1] - heights[0]);
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int prevEnergy1 = getMinEnergy(index-1, heights, dp) + Math.abs(heights[index] - heights[index-1]);
        int prevEnergy2 = getMinEnergy(index-2, heights, dp) + Math.abs(heights[index] - heights[index-2]);
        return dp[index] = Math.min(prevEnergy1, prevEnergy2);
    }
}
