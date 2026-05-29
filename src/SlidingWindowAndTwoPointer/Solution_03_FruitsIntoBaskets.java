package SlidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class Solution_03_FruitsIntoBaskets {
    // Similar question
    // Find the max length subarray having k distinct element
    // Time complexity O(2*n)
    // Space complexity O(2) : constant
    public int totalFruits(int[] fruits) {
        int left = 0, right = 0, length = fruits.length, maxValue = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        while (right < length) {
            hashMap.merge(fruits[right], 1, Integer::sum);
            while (hashMap.size() > 2) {
                // How merge worked
                // https://chatgpt.com/share/6a18625a-08a0-83ab-99e7-b4679bc8b1a1
                hashMap.merge(fruits[left], -1, (oldValue, newValue) -> {
                    newValue += oldValue;
                    return newValue == 0 ? null : newValue;
                });
                left++;
            }
            maxValue = Math.max(maxValue, right - left + 1);
            right++;
        }
        return maxValue;
    }
}
