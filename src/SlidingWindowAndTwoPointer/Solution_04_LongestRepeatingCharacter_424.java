package SlidingWindowAndTwoPointer;

// https://youtu.be/_eNhaDCr6P0?t=1263
// Example - "AAABBCCD"
// Time complexity O(26*n)
// Space complexity O(26)
public class Solution_04_LongestRepeatingCharacter_424 {
    public static int characterReplacement(String s, int k) {
        int size = s.length(), left = 0, right = 0, maxLength = 0, maxFreq = 0;
        int[] hash = new int[26];
        while (right < size) {
            char ch = s.charAt(right);
            int chValue = ch - 'A';
            hash[chValue]++;
            maxFreq = Math.max(maxFreq, hash[chValue]);
            if ((right - left + 1) - maxFreq > k) {
                ch = s.charAt(left);
                chValue = ch - 'A';
                hash[chValue]--;
                maxFreq = 0;
                // We can avoid checking maxFreq updated value
                // maxFreq is not responsible to get the longest substring
                // To understand more, check the video
                for (int i=0; i<26; ++i) {
                    maxFreq = Math.max(maxFreq, hash[i]);
                }
                ++left;
            }
            if ((right - left + 1) - maxFreq <= k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            ++right;
        }
        return maxLength;
    }

    // Best solution
    // Time complexity O(26*n)
    // Space complexity O(26)
    public int characterReplacementBestSolution(String s, int k) {
        int size = s.length(), left = 0, right = 0, maxLength = 0, maxFreq = 0;
        int[] hash = new int[26];
        while (right < size) {
            char ch = s.charAt(right);
            int chValue = ch - 'A';
            hash[chValue]++;
            maxFreq = Math.max(maxFreq, hash[chValue]);
            if ((right - left + 1) - maxFreq > k) {
                ch = s.charAt(left);
                chValue = ch - 'A';
                hash[chValue]--;
                maxFreq = 0;
                ++left;
            }
            if ((right - left + 1) - maxFreq <= k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            ++right;
        }
        return maxLength;
    }
}
