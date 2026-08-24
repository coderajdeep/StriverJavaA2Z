package __08__SlidingWindowAndTwoPointer;

public class Solution_11_MinimumWindowSubstring_76 {
    // Time complexity O(n^2)
    // Space Complexity O(52) ~ constant
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length(), minLen = Integer.MAX_VALUE, sIndex = -1;
        // edge case
        if (n == 0 || m == 0 || n < m) {
            return "";
        }
        else if (s.equals(t)) {
            return s;
        }
        for (int i=0; i<n; ++i) {
            int[] hash = new int[52];
            // Increase frequency of each element in t by their occurrence
            for (int j=0; j<m; ++j) {
                hash[getIndex(t.charAt(j))]++;
            }
            int cnt = 0;
            for (int j=i; j<n; ++j) {
                // This will happen when the element already exist in t and haven't neutral the frequency
                if (hash[getIndex(s.charAt(j))] > 0) {
                    ++cnt;
                }
                // Reduce the frequency
                hash[getIndex(s.charAt(j))]--;
                // When all the element present in s also the freq is also same
                if (cnt == m && (j - i + 1 < minLen)) {
                    minLen = j - i + 1;
                    sIndex = i;
                    break;
                }
            }
        }
        // No substring exist
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(sIndex, sIndex + minLen);
    }
    private int getIndex(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return ch - 'a';
        }
        return (ch - 'A') + 26;
    }

    // Optimized the brute force solution
    // Time complexity O(n)
    // Space Complexity O(52) ~ constant
    // Main principle is - if t insert eny char into hash, then freq increase
    // if s insert then freq decrease
    public String minWindowOptimizedVersion(String s, String t) {
        int n = s.length(), m = t.length(), minLen = Integer.MAX_VALUE, sIndex = -1, left = 0, right = 0, cnt = 0;
        if (n == 0 || m == 0 || n < m) {
            return "";
        }
        else if (s.equals(t)) {
            return s;
        }
        int[] hash = new int[52];
        for (int i=0; i<m; ++i) {
            hash[getIndex(t.charAt(i))]++;
        }
        while (right < n) {
            if (hash[getIndex(s.charAt(right))] > 0) {
                cnt++;
            }
            hash[getIndex(s.charAt(right))]--;
            while (left <= right && cnt == m) {
                if (minLen > (right - left +1)) {
                    minLen = right - left + 1;
                    sIndex = left;
                }
                hash[getIndex(s.charAt(left))]++;
                if (hash[getIndex(s.charAt(left))] > 0) {
                    cnt--;
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(sIndex, sIndex + minLen);
    }
}
