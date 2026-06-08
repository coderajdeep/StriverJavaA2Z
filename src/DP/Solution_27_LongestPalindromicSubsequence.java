package DP;

public class Solution_27_LongestPalindromicSubsequence {
    // Time complexity O(n^2)
    // Space complexity O(n) 1D array
    // Tabulation (Bottom up)
    public int longestPalindromicSubsequence(String s) {
        int n = s.length();
        String str = getReversedString(n, s);
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
            System.arraycopy(curr, 0, prev, 0, n+1);
        }
        for (int e : prev) {
            System.out.println(e);
        }
        return prev[n];
    }
    private String getReversedString(int n, String s) {
        char[] str = new char[n];
        int i = 0, j = n-1;
        while (i < j) {
            str[i] = s.charAt(j);
            str[j] = s.charAt(i);
            i++;
            j--;
        }
        if (n % 2 == 1) {
            str[n/2] = s.charAt(n/2);
        }
        return String.valueOf(str);
    }
}
