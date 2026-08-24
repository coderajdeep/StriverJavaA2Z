package __08__SlidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class Solution_09_LongestSubstringWithAtMostKDistinctCharacters_340 {
    // Time complexity O(2*n)
    // Space complexity O(k)
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0, right = 0, maxLen = 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        while (right < s.length()) {
            hashMap.merge(s.charAt(right), 1, Integer::sum);
            while (hashMap.size() > k) {
                hashMap.merge(s.charAt(left), -1, (oldValue, newValue) -> {
                    int value = oldValue + newValue;
                    return value == 0 ? null : value;
                });
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
