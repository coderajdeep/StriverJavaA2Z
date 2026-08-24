package __08__SlidingWindowAndTwoPointer;

// Example - "AAABBCCD"

public class Solution_04_LongestRepeatingCharacter_424 {

    // Best solution
    // Time complexity O(n)
    // Space complexity O(26) : constant
    // https://chatgpt.com/share/6a1958eb-d0a8-8323-9764-dd11cbec5684
    // https://youtu.be/_eNhaDCr6P0?t=1263
    public int characterReplacementBestSolution(String s, int k) {
        int maxLen = 0, maxFreq = 0, length = s.length(), left = 0, right = 0;
        int[] hash = new int[26];
        while (right < length) {
            int charValue = s.charAt(right) - 'A';
            hash[charValue]++;
            maxFreq = Math.max(maxFreq, hash[charValue]);

            // maxFreq is the maximum frequency ever seen in the window,
            // not necessarily the current maximum frequency.
            //
            // We intentionally do NOT decrease maxFreq when shrinking.
            // A stale maxFreq may make some invalid windows look valid,
            // but it never affects the final answer because maxFreq only
            // grows and represents a frequency that actually existed in
            // some earlier window. This allows an O(N) solution.
            if ((right-left+1) - maxFreq > k) {
                charValue = s.charAt(left) - 'A';
                hash[charValue]--;
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }

    // Time complexity O(n*26)
    // Space complexity O(26)
    public static int characterReplacement(String s, int k) {
        int maxLen = 0, maxFreq = 0, length = s.length(), left = 0, right = 0;
        int[] hash = new int[26];
        while (right < length) {
            int charValue = s.charAt(right) - 'A';
            hash[charValue]++;
            maxFreq = Math.max(maxFreq, hash[charValue]);
            if ((right-left+1) - maxFreq > k) {
                charValue = s.charAt(left) - 'A';
                hash[charValue]--;
                left++;
                // We can avoid checking maxFreq updated value
                // maxFreq is not responsible to get the longest substring
                // To understand more, check the video or ChatGPT explanation
                // https://youtu.be/_eNhaDCr6P0?t=1263
                for (int i=0; i<26; i++) {
                    maxFreq = Math.max(maxFreq, hash[i]);
                }
            }
            if ((right-left+1) - maxFreq <= k) {
                maxLen = Math.max(maxLen, right-left+1);
            }
            right++;
        }
        return maxLen;
    }

    // Brute force approach
    // Time complexity O(n*n)
    // Space complexity O(26)
    public int characterReplacementBruteForce(String s, int k) {
        int maxLen = 0, maxFreq, length = s.length();
        for (int i=0; i<length; i++) {
            int[] hash = new int[26];
            maxFreq = 0;
            for (int j=i; j<length; j++) {
                int index = s.charAt(j) - 'A';
                hash[index]++;
                maxFreq = Math.max(maxFreq, hash[index]);
                if (((j-i+1)-maxFreq) <= k) {
                    maxLen = Math.max(maxLen, j-i+1);
                }
                else {
                    break;
                }
            }
        }
        return maxLen;
    }
}
