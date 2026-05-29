package SlidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

// Similar question -> Number of substring having all distinct characters of the string itself

public class Solution_07_NumberOfSubstringContainingAllThreeCharacter_1358 {
    // Best approach
    // Time complexity O(n)
    // Space complexity O(1)
    public int numberOfSubstringsWithOutHashMap(String s) {
        int aIndex = -1, bIndex = -1, cIndex = -1, count = 0;
        for (int index = 0; index < s.length(); index++) {
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
                int minIndex = Math.min(aIndex, Math.min(bIndex, cIndex));
                count += (minIndex + 1);
            }
        }
        return count;
    }

    // Using HashMap
    // Similar approach as the previous one
    // Time complexity O(n)
    // Space complexity O(1) [Map will contain at most 3 element]
    public int numberOfSubstringsUsingMap(String s) {
        return numberOfSubstringsWithAllCharacters(s, 3);
    }
    // In the given string, there are total k distinct characters
    public int numberOfSubstringsWithAllCharacters(String s, int k) {
        int count = 0;
        Map<Character, Integer> hashMap = new HashMap<> ();
        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i), i);
            if (hashMap.size() == k) {
                int minIndex = s.length();
                for(int value : hashMap.values()) {
                    minIndex = Math.min(minIndex, value);
                }
                count += (minIndex + 1);
            }
        }
        return count;
    }

    // Time complexity O(n)
    // Space complexity O(1) [Map will contain at most 3 element]
    // This approach is not preferred and not easily understandable
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
