package DP;

public class Solution_25_PrintLongestCommonSubsequence {
    // https://chatgpt.com/share/6a22f4ca-2cd4-8324-8647-08fe5d06d6b8
    public static String findLCS(int n, int m, String s1, String s2){
        int[][] dp = getLCSArray(n, m, s1, s2);
        int len = dp[n][m];
        char[] result = new char[len];
        int i = n, j = m, index = len-1;
        while (i > 0 && j > 0 && index >= 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                result[index] = s1.charAt(i-1);
                i--;
                j--;
                index--;
            }
            else if (dp[i][j-1] > dp[i-1][j]) {
                j--;
            }
            else {
                i--;
            }
        }
        return String.valueOf(result);
    }

    private static int[][] getLCSArray(int n, int m, String s1, String s2) {
        int[][] dp = new int[n+1][m+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp;
    }
}
