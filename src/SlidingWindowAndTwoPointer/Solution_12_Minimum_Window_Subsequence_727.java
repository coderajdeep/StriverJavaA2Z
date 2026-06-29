package SlidingWindowAndTwoPointer;

import java.util.Arrays;

public class Solution_12_Minimum_Window_Subsequence_727 {
    // https://youtu.be/W2DvQcDPD9A
    // Time complexity O(n1*n2)
    // Space complexity O(1)
    // Greedy approach
    // Intuitive approach
    public String minWindow(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 < n2) {
            return "";
        }
        int startIndex = -1, endIndex = -1, minLength = n1 + 1, j = 0;
        for (int i = 0; i<n1; i++) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
                if (j == n2) {
                    endIndex = i;
                    j--;
                    while (j >= 0) {
                        if (s1.charAt(i) == s2.charAt(j)) {
                            j--;
                        }
                        i--;
                    }
                    i++;
                    j++;
                    if ((endIndex - i + 1) < minLength) {
                        minLength = endIndex - i + 1;
                        startIndex = i;
                    }
                }
            }
        }
        return startIndex == -1 ? "" : s1.substring(startIndex, startIndex + minLength);
    }


    // Time complexity O(n1*n2)
    // Space complexity O(n1*n2)
    // DP approach
    public String minWindowDP(String s1, String s2) {
        int n = s1.length(), m = s2.length(), minLength = n+1, startIndex = -1, endIndex = -1;
        int[][] dp = new int[n+1][m+1];
        Arrays.fill(dp[0], n+1);
        dp[0][0] = 0;
        // dp[i][j] -> min length substring of s1 which is ending at index (i-1)
        // and contains s2 subsequence till index (j-1)
        for (int i=1; i<=n; i++) {
            dp[i][0] = 0;
            for (int j=1; j<=m; j++) {
                // check tuf article explanation
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = 1 + dp[i-1][j];
                }
            }
            if (dp[i][m] < minLength) {
                minLength = dp[i][m];
                endIndex = i-1;
            }
        }
        if (endIndex == -1) {
            return "";
        }
        char[] result = new char[minLength];
        for (int i=0; i<minLength; i++) {
            result[minLength-1-i] = s1.charAt(endIndex-i);
        }
        return String.valueOf(result);
    }
}
