package DP;

import java.util.Arrays;

public class Solution_29_MinInsertionOrDeletionToConvertStringAtoB {

    // Best approach
    // Time complexity O(n1*n2)
    // Space complexity O(n2) 1D array
    // Tabulation (Bottom up)
    // Very intuitive solution
    public int minOperations(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int lcs = getLCS(s1, s2);
        // lcs length subsequence is common in both String
        // (n1 - lcs) length needs to be deleted from s1
        // then (n2 - lcs) number of character needs to be inserted into s1 to match with s2
        return (n1 - lcs) + (n2 - lcs);
    }
    private int getLCS(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
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
    // Space complexity O(n2) 1D array
    // Tabulation (Bottom up)
    public int minOperationsSpaceOptimized(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[] prev = new int[n2+1];
        int[] curr = new int[n2+1];
        for (int i=0; i<=n2; i++) {
            prev[i] = i;
        }
        for (int i=1; i<=n1; i++) {
            curr[0] = i;
            for (int j=1; j<=n2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    curr[j] = prev[j-1];
                }
                else {
                    curr[j] = 1 + Math.min(curr[j-1], prev[j]);
                }
            }
            System.arraycopy(curr, 0, prev, 0, n2+1);
        }
        return prev[n2];
    }


    // Time complexity O(n1*n2)
    // Space complexity O(n1*n2) 2D array
    // Tabulation (Bottom up)
    public int minOperationsTabulation(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        for (int i=1; i<=n2; i++) {
            dp[0][i] = i;
        }
        for (int i=1; i<=n1; i++) {
            dp[i][0] = i;
            for (int j=1; j<=n2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }



    // Time complexity O(n1*n2)
    // Space complexity O(n1*n2) 2D array + O(max(n1,n2)) Recursion stack
    // Memoization (Top down)
    public int minOperationsMemoization(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        fill(n1+1, dp);
        return getMin(n1, n2, s1, s2, dp);
    }
    private int getMin(int n1, int n2, String s1, String s2, int[][] dp) {
        if (n1==0 && n2==0) {
            return 0;
        }
        if (n1==0) {
            return n2;
        }
        if (n2==0) {
            return n1;
        }
        if (dp[n1][n2] != -1) {
            return dp[n1][n2];
        }
        if (s1.charAt(n1-1) == s2.charAt(n2-1)) {
            return dp[n1][n2] = getMin(n1-1, n2-1, s1, s2, dp);
        }
        else {
            // Insert s2.charAt(n2-1) in s1
            int insert = 1 + getMin(n1, n2-1, s1, s2, dp);
            // Delete s1.charAt(n1-1) from s1
            int delete = 1 + getMin(n1-1, n2, s1, s2, dp);
            return dp[n1][n2] = Math.min(insert, delete);
        }
    }
    private void fill(int n, int[][] dp) {
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
    }
}
