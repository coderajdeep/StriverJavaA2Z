package Array;

import java.util.HashMap;
import java.util.Map;

public class Solution_13_LargestSubArrayWithGivenSumNonNegative {
    // This will work for non-negative numbers only,
    // if we have negative numbers then we need to use prefix sum and hashing approach
    // Time complexity O(2*n) ~ O(n)
    // Space complexity O(1)
    int longestSubArrayWithSumK(int[] nums, int k) {
        int size = nums.length, left = 0, right = 0, maxLength = 0, sum = 0;
        // This will traverse n
        while (right < size) {
            sum += nums[right];
            // This will traverse max of n
            while (left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }
            if (left <= right && sum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }
        return maxLength;
    }

    // Time complexity O(n)
    // Space complexity O(1)
    public int longestSubArrayWithGivenSum(int[] nums, int k) {
        int size = nums.length, index = 0, maxLength = 0;
        long sum = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        while (index < size) {
            sum += nums[index];
            Integer leftIndex = map.get(sum - k);
            if (leftIndex != null) {
                maxLength = Math.max(maxLength, index - leftIndex);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, index);
            }
            index++;
        }
        return maxLength;
    }
}
