package DP;

import java.util.Arrays;

public class Solution_33_WildcardMatching_44 {

    // Best Space optimized
    // Time complexity O(n1*n2)
    // Space complexity O(n2) 1D array
    // Tabulation (Bottom up)
    public boolean wildCardBestSolution(String str, String pat) {
        int n1 = str.length();
        int n2 = pat.length();
        boolean[] prev = new boolean[n2+1];
        boolean[] curr = new boolean[n2+1];
        prev[0] = true;
        for (int i=1; i<=n2; i++) {
            prev[i] = pat.charAt(i-1) == '*' && prev[i-1];
        }
        for (int i=1; i<=n1; i++) {
            curr[0] = false;
            for (int j=1; j<=n2; j++) {
                if (str.charAt(i-1) == pat.charAt(j-1) || pat.charAt(j-1) == '?') {
                    curr[j] = prev[j-1];
                }
                else if (pat.charAt(j-1) == '*') {
                    boolean matchWithNonEmptyChar = prev[j];
                    boolean matchWithEmptyChar = curr[j-1];
                    curr[j] = matchWithNonEmptyChar || matchWithEmptyChar;
                }
                else {
                    curr[j] = false;
                }
            }
            System.arraycopy(curr, 0, prev, 0, n2+1);
        }
        return prev[n2];
    }

    // Time complexity O(n1*n2)
    // Space complexity O(n1*n2) 2D array
    // Tabulation (Bottom up)
    public boolean wildCardTabulation(String str, String pat) {
        int n1 = str.length();
        int n2 = pat.length();
        boolean[][] dp = new boolean[n1+1][n2+1];
        dp[0][0] = true;
        for (int i=1; i<=n2; i++) {
            dp[0][i] = pat.charAt(i-1) == '*' && dp[0][i-1];
        }
        for (int i=1; i<=n1; i++) {
            dp[i][0] = false;
            for (int j=1; j<=n2; j++) {
                if (str.charAt(i-1) == pat.charAt(j-1) || pat.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if (pat.charAt(j-1) == '*') {
                    boolean matchWithNonEmptyChar = dp[i-1][j];
                    boolean matchWithEmptyChar = dp[i][j-1];
                    dp[i][j] = matchWithNonEmptyChar || matchWithEmptyChar;
                }
                else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n1][n2];
    }

    // Time complexity O(n1*n2)
    // Space complexity O(n1*n2) 2D array + O(max(n1,n2)) Recursion stack
    // Memoization (Top down)
    public boolean wildCardMemoization(String str, String pat) {
        int n1 = str.length();
        int n2 = pat.length();
        int[][] dp = new int[n1+1][n2+1];
        fill(n1+1, dp);
        return isMatched(n1, n2, str, pat, dp) == 1;
    }
    private int isMatched(int n1, int n2, String str, String pat, int[][] dp) {
        if (n1 == 0) {
            for (int i=0; i<n2; i++) {
                if (pat.charAt(i) != '*') {
                    return 0;
                }
            }
            return 1;
        }
        if (n2 == 0) {
            return 0;
        }
        if (dp[n1][n2] != -1) {
            return dp[n1][n2];
        }
        if (pat.charAt(n2-1) == '?' || pat.charAt(n2-1) == str.charAt(n1-1)) {
            return dp[n1][n2] = isMatched(n1-1, n2-1, str, pat, dp);
        }
        else if (pat.charAt(n2-1) == '*') {
            int matchNonEmptyChar = isMatched(n1-1, n2, str, pat, dp);
            int matchEmptyChar = isMatched(n1, n2-1, str, pat, dp);
            return dp[n1][n2] = ((matchNonEmptyChar == 1 || matchEmptyChar == 1) ? 1 : 0);
        }
        else {
            return dp[n1][n2] = 0;
        }
    }
    private void fill(int n, int[][] dp) {
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
    }
}
