package SlidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class Solution_07_NumberOfSubstringContainingAllThreeCharacter_1358 {
    // Best approach
    // Time complexity O(n)
    // Space complexity O(1)
    public int numberOfSubstringsWithOutHashMap(String s) {
        int size = s.length(), index = 0, count = 0, aIndex = -1, bIndex = -1, cIndex = -1;
        while (index < size) {
            char ch = s.charAt(index);
            if (ch == 'a') {
                aIndex = index;
            }
            else if (ch == 'b') {
                bIndex = index;
            }
            else if (ch == 'c') {
                cIndex = index;
            }
            if (aIndex != -1 && bIndex != -1 && cIndex != -1) {
                // if [minIndex-index] substring exist all the character
                // then the following substring will also contain all the element
                // [(minIndex-1) index] [(minIndex-2) index] [(minIndex-3) index] [0 index]
                // There are total (minIndex - 0 + 1) -> (minIndex + 1) substring exist
                int minIndex = Math.min(Math.min(aIndex, bIndex), cIndex);
                count += (minIndex + 1);
            }
            ++index;
        }
        return count;
    }

    // Time complexity O(n)
    // Space complexity O(1) [Map will contain at most 3 element]
    public int numberOfSubstrings(String s) {
        int size = s.length(), left = 0, right = 0, count = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < size) {
            map.merge(s.charAt(right), 1, Integer::sum);
            while ((left <= right) && map.containsKey('a') && map.containsKey('b') && map.containsKey('c')) {
                // if [left-right] substring exist all the character
                // then the following substring will also contain all the element [left-right+1] [left-right+2] .. [left-size-1]
                // There are total (size - 1 - right + 1) -> (size - right) substring exist
                count += (size - right);
                map.merge(s.charAt(left), -1, (oldValue, diff) -> {
                    int newValue = oldValue + diff;
                    return newValue == 0 ? null : newValue;
                });
                ++left;
            }
            ++right;
        }
        return count;
    }
}
