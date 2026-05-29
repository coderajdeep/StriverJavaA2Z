package SlidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_01_LongestSubstringWithoutRepeatingCharacter_3 {

    // Time complexity O(n)
    // Space complexity O(256) : constant
    public int longestNonRepeatingSubstringBestApproach(String s) {
        int left = 0, right = 0, maxLength = 0, length = s.length();
        Map<Character, Integer> hashMap = new HashMap<>();
        while (right < length) {
            char ch = s.charAt(right);
            Integer index = hashMap.get(ch);
            if (index == null || index < left) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            else {
                left = index + 1;
            }
            hashMap.put(ch, right);
            right++;
        }
        return maxLength;
    }

    // Time complexity O(2*n)
    // Space complexity O(256) : constant
    // abcdefghii -> 2n traversal
    // For this input, we need to traverse the entire string twice
    public int longestNonRepeatingSubstring(String s) {
        int left = 0, right = 0, maxLength = 0, length = s.length();
        Set<Character> hashSet = new HashSet<>();
        while (right < length) {
            if (!hashSet.contains(s.charAt(right))) {
                maxLength = Math.max(maxLength, right - left + 1);
                hashSet.add(s.charAt(right));
                right++;
            }
            else {
                hashSet.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
}
