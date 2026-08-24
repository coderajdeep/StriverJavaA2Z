package __14__DP;

import java.util.Arrays;

public class Solution_31_DistinctSubsequence_115 {

    // Space optimized
    // Time complexity O(n1*n2)
    // Space complexity O(n2) 1D array
    // Tabulation (Bottom up)
    public int numDistinctBestSpaceOptimized(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int[] dp = new int[n2+1];
        dp[0] = 1;
        for (int i=1; i<=n1; i++) {
            for (int j=n2; j>=1; j--) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    // we can take or not take
                    // matching with target
                    int take = dp[j-1];
                    // not matching with target
                    int notTake = dp[j];
                    dp[j] = take + notTake;
                }
                else {
                    // here we don't have option to match
                    // so we have only one option
                    dp[j] = dp[j];
                }
            }
        }
        return dp[n2];
    }

    // Time complexity O(n1*n2)
    // Space complexity O(n1*n2) 2D array
    // Tabulation (Bottom up)
    public int numDistinctTabulation(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int[][] dp = new int[n1+1][n2+1];
        dp[0][0] = 1;
        for (int i=1; i<=n1; i++) {
            dp[i][0] = 1;
            for (int j=1; j<=n2; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    // we can take or not take
                    // matching with target
                    int take = dp[i-1][j-1];
                    // not matching with target
                    int notTake = dp[i-1][j];
                    dp[i][j] = take + notTake;
                }
                else {
                    // here we don't have option to match
                    // so we have only one option
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n1][n2];
    }

    // Time complexity O(n1*n2)
    // Space complexity O(n1*n2) 2D array + O(max(n1,n2)) Recursion stack
    // Memoization (Top down)
    public int numDistinctMemoization(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int[][] dp = new int[n1+1][n2+1];
        fill(n1+1, dp);
        return getCount(n1, n2, s, t, dp);
    }
    private int getCount(int n1, int n2, String s, String t, int[][] dp) {
        if (n2 == 0) {
            return 1;
        }
        if (n1 == 0) {
            return 0;
        }
        if (dp[n1][n2] != -1) {
            return dp[n1][n2];
        }
        int match = 0, notMatch = 0, total = 0;
        if (s.charAt(n1-1) == t.charAt(n2-1)) {
            match = getCount(n1-1, n2-1, s, t, dp);
            notMatch = getCount(n1-1, n2, s, t, dp);
            total = (match + notMatch);
        }
        else {
            notMatch = getCount(n1-1, n2, s, t, dp);
            total = notMatch;
        }
        return dp[n1][n2] = total;
    }
    private void fill(int n, int[][] dp) {
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
    }
}
