package __08__SlidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class Solution_10_totalSubArrayWithKDistinctIntegers_992 {
    // Time complexity O(2*n)
    // Space complexity O(1)
    public int subarraysWithKDistinct(int[] nums, int k) {
        return (int)(subarraysWithAtMostKDifferentIntegers(nums, k) - subarraysWithAtMostKDifferentIntegers(nums, k-1));
    }
    private long subarraysWithAtMostKDifferentIntegers(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int left = 0, right = 0;
        long count = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        while (right < nums.length) {
            hashMap.merge(nums[right], 1, Integer::sum);
            while (hashMap.size() > k) {
                hashMap.merge(nums[left], -1, (old, diff) -> {
                    int newValue = old + diff;
                    return newValue == 0 ? null : newValue;
                });
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }
}
