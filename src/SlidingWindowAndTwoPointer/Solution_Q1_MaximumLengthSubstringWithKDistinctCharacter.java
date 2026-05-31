package SlidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
// Similar to Solution_03_FruitsIntoBaskets (At most K distinct elements in a subarray)
// Similar to Solution_09_LongestSubstringWithAtMostKDistinctCharacters_340 (At most K distinct characters)

public class Solution_Q1_MaximumLengthSubstringWithKDistinctCharacter {
    // Time complexity O(2*n)
    // Space complexity O(1)
    public int longestKSubstr(String s, int k) {
        int left = 0, right = 0, maxLength = -1;
        Map<Character, Integer> hashMap = new HashMap<>();
        while (right < s.length()) {
            hashMap.merge(s.charAt(right), 1, Integer::sum);
            while(hashMap.size() > k) {
                hashMap.merge(s.charAt(left), -1, (old, diff) -> {
                    int newValue = old + diff;
                    return newValue == 0 ? null : newValue;
                });
                left++;
            }
            if (hashMap.size() == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }
        return maxLength;
    }
}
