package DP;

import java.util.Arrays;

public class Solution_24_LongestCommonSubsequence_1143 {
    // Best Solution
    // Time complexity O(n1*n2)
    // Space complexity O(n2) 1D array
    // Tabulation (Bottom up)
    public int lcsBestSolution(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        // default value is zero when we initialize an array in java
        // for first row and column, value will be zero
        int[] prev = new int[n2+1];
        int[] curr = new int[n2+1];
        for (int i=1; i<=n1; i++) {
            for (int j=1; j<=n2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    curr[j] = 1 + prev[j-1];
                }
                else {
                    curr[j] = Math.max(curr[j-1], prev[j]);
                }
            }
            System.arraycopy(curr, 0, prev, 0, n2+1);
        }
        return prev[n2];
    }

    // Time complexity O(n1*n2)
    // Space complexity O(n1*n2) 2D array
    // Tabulation (Bottom up)
    public int lcsTabulation(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        // default value is zero when we initialize an array in java
        // for first row and column, value will be zero
        int[][] dp = new int[n1+1][n2+1];
        for (int i=1; i<=n1; i++) {
            for (int j=1; j<=n2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n1][n2];
    }


    // Time complexity O(n1*n2)
    // Space complexity O(n1*n2) 2D array + Recursion function call stack O(n1)
    // Memoization (Top down)
    public int lcsMemoization(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        fill(n1 + 1, dp);
        return getLCS(n1, n2, s1, s2, dp);
    }
    private int getLCS(int n1, int n2, String s1, String s2, int[][] dp) {
        if (n1 == 0 || n2 == 0) {
            return 0;
        }
        if (dp[n1][n2] != -1) {
            return dp[n1][n2];
        }
        if (s1.charAt(n1-1) == s2.charAt(n2-1)) {
            return dp[n1][n2] = 1 + getLCS(n1-1, n2-1, s1, s2, dp);
        }
        else {
            int len1 = getLCS(n1-1, n2, s1, s2, dp);
            int len2 = getLCS(n1, n2-1, s1, s2, dp);
            return dp[n1][n2] = Math.max(len1, len2);
        }
    }
    private void fill(int n, int[][] dp) {
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
    }
}
