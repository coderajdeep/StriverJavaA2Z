package __14__DP;

import java.util.Arrays;

public class Solution_32_EditDistance_72 {

    // Best Space optimized
    // Time complexity O(n1*n2)
    // Space complexity O(n2) 1D array
    // Tabulation (Bottom up)
    public int minDistanceBestSolution(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int[] prev = new int[n2+1];
        int[] curr = new int[n2+1];
        for (int i=1; i<=n2; i++) {
            prev[i] = i;
        }
        for (int i=1; i<=n1; i++) {
            curr[0] = i;
            for (int j=1; j<=n2; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    curr[j] = prev[j-1];
                }
                else {
                    int insert = curr[j-1];
                    int delete = prev[j];
                    int replace = prev[j-1];
                    curr[j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
            System.arraycopy(curr, 0, prev, 0, n2+1);
        }
        return prev[n2];
    }

    // Time complexity O(n1*n2)
    // Space complexity O(n1*n2) 2D array
    // Tabulation (Bottom up)
    public int editDistanceTabulation(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int[][] dp = new int[n1+1][n2+1];
        for (int i=1; i<=n2; i++) {
            dp[0][i] = i;
        }
        for (int i=1; i<=n1; i++) {
            dp[i][0] = i;
            for (int j=1; j<=n2; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    int insert = dp[i][j-1];
                    int delete = dp[i-1][j];
                    int replace = dp[i-1][j-1];
                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[n1][n2];
    }

    // Time complexity O(n1*n2)
    // Space complexity O(n1*n2) 2D array + O(max(n1,n2)) Recursion stack
    // Memoization (Top down)
    public int editDistanceMemoization(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int[][] dp = new int[n1+1][n2+1];
        fill(n1+1, dp);
        return getMin(n1, n2, s, t, dp);
    }
    private int getMin(int n1, int n2, String s, String t, int[][] dp) {
        if (n1 == 0 && n2 == 0) {
            return 0;
        }
        if (n1 == 0) {
            return n2;
        }
        if (n2 == 0) {
            return n1;
        }
        if (dp[n1][n2] != -1) {
            return dp[n1][n2];
        }
        if (s.charAt(n1-1) == t.charAt(n2-1)) {
            return dp[n1][n2] = getMin(n1-1, n2-1, s, t, dp);
        }
        int insert = getMin(n1, n2-1, s, t, dp);
        int delete = getMin(n1-1, n2, s, t, dp);
        int replace = getMin(n1-1, n2-1, s, t, dp);
        return dp[n1][n2] = 1 + Math.min(insert, Math.min(delete, replace));
    }

    private void fill(int n, int[][] dp) {
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
    }
}
