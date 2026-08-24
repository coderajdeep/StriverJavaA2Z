package __14__DP;

public class Solution_26_LongestCommonSubstring {

    // Time complexity O(n1*n2)
    // Space complexity O(n2) 1D array
    // Tabulation (Bottom up)
    public int longestCommonSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] dp = new int[m+1];
        int maxLength = 0;
        for (int i=1; i<=n; i++) {
            for (int j=m; j>=1; j--) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[j] = 1 + dp[j-1];
                    maxLength = Math.max(maxLength, dp[j]);
                }
                else {
                    dp[j] = 0;
                }
            }
        }
        return maxLength;
    }


    // Time complexity O(n1*n2)
    // Space complexity O(n1*n2) 2D array
    // Tabulation (Bottom up)
    public int longestCommonSubstrTabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        int maxLength = 0;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength;
    }
}
