package __14__DP;

import java.util.Arrays;

public class Solution_02_climbingStairs_70 {
    // Time complexity O(n)
    // Space complexity O(1)
    // Space optimized tabulation
    public int climbStairsBestSolution(int n) {
        // given n >= 1
        // Initially climber starts from 0th staircase
        // for n == 0, ans -> 1
        if (n <= 2) return n;
        int prev2 = 1, prev1 = 2;
        for (int i=3; i<=n; i++) {
            int temp = prev2 + prev1;
            prev2 = prev1;
            prev1 = temp;
        }
        return prev1;
    }

    // Time complexity O(n)
    // Space complexity O(n)
    // Tabulation (Bottom up)
    public int climbStairsUsingTabulation(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // Time complexity O(n)
    // Space complexity O(2*n) -> 1D array + Recursion stack space
    // Memoization (Top down)
    public int climbStairsUsingMemoization(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return getCount(n, dp);
    }
    private int getCount(int n, int[] dp) {
        if (n <= 2) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = getCount(n-1, dp) + getCount(n-2, dp);
    }
}
