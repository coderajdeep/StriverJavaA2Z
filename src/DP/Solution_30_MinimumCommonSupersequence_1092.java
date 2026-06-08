package DP;

public class Solution_30_MinimumCommonSupersequence_1092 {
    // Time complexity O(n1*n2)
    // Space complexity O(n1*n2) 2D array
    // Tabulation (Bottom up)
    public String shortestCommonSupersequence(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = getLCSArray(s1, s2);
        int lcs = dp[n1][n2];
        int scs = (n1 + n2 - lcs);
        char[] result = new char[scs];
        int i = n1, j = n2, index = scs - 1;
        while (i > 0 && j > 0 && index >= 0) {
            char ch1 = s1.charAt(i-1);
            char ch2 = s2.charAt(j-1);
            if (ch1 == ch2) {
                result[index--] = ch1;
                i--;
                j--;
            }
            else if (dp[i-1][j] > dp[i][j-1]) {
                result[index--] = ch1;
                i--;
            }
            else {
                result[index--] = ch2;
                j--;
            }
        }
        while (i > 0 && index >= 0) {
            result[index--] = s1.charAt(i-1);
            i--;
        }
        while (j > 0 && index >= 0) {
            result[index--] = s2.charAt(j-1);
            j--;
        }
        return String.valueOf(result);
    }
    private int[][] getLCSArray(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
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
        return dp;
    }
}
