package SlidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

// https://www.naukri.com/code360/problems/shortest-substring-with-all-characters_704894
public class Solution_Q2_ShortestSubstringWhichContainsAllCharacters {
    // Time complexity O(n)
    // Space complexity O(26)
    // Very simple to Solution_11_Minimum_Window_Subsequence_727
    public static String shortestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, 1);
        }
        int left = 0, right = 0, minLength = n+1, startIndex = -1, totalChar = map.size(), count = 0;
        while (right < n) {
            char ch = s.charAt(right);
            if (map.getOrDefault(ch, 0) > 0) {
                count++;
            }
            map.merge(ch, -1, Integer::sum);
            while (left <= right && count == totalChar) {
                if ((right - left + 1) < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }
                char c = s.charAt(left);
                map.merge(c, 1, Integer::sum);
                if (map.getOrDefault(c, 0) > 0) {
                    count--;
                }
                left++;
            }
            right++;
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLength);
    }
}
