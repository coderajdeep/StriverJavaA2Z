package DP;

public class Solution_28_MinInsertionToMakeStringPalindrome_1312 {
    public int minInsertions(String s) {
        int n = s.length();
        int lpsLength = longestPalindromicSubsequence(n, s);
        // Characters that are already part of the longest palindromic subsequence
        // do not need any insertion.
        // All remaining characters must be adjusted through insertions
        // to make the entire string a palindrome.
        return (n - lpsLength);
    }
    public int longestPalindromicSubsequence(int n, String s) {
        // LPS can be found by calculating the LCS between
        // the original string and its reversed version.
        String str = new StringBuilder(s).reverse().toString();
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (s.charAt(i-1) == str.charAt(j-1)) {
                    curr[j] = 1 + prev[j-1];
                }
                else {
                    curr[j] = Math.max(curr[j-1], prev[j]);
                }
            }
            // Current row becomes previous row for the next iteration
            System.arraycopy(curr, 0, prev, 0, n+1);
        }
        return prev[n];
    }
}
