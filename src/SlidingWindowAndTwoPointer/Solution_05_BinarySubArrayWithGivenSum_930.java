package SlidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class Solution_05_BinarySubArrayWithGivenSum_930 {
    // Time complexity O(2*n)
    // Space complexity O(1)
    // This will only work if the elements are not negative
    public static int numSubArraysWithSum(int[] nums, int goal) {
        return numOfSubArraysWithAtMostGivenSum(nums, goal) - numOfSubArraysWithAtMostGivenSum(nums, goal-1);
    }
    public static int numOfSubArraysWithAtMostGivenSum(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }
        int size = nums.length, left = 0, right = 0, sum = 0, count = 0;
        while (right < size) {
            sum += nums[right];
            while (left <= right && sum > goal) {
                sum -= nums[left];
                ++left;
            }
            // sum -> window sum between left and right inclusive
            // count -> total subarray having sum <= k and subarray is ending at index right
            count += (right - left + 1);
            ++right;
        }
        return count;
    }

    // Time complexity O(n)
    // Space complexity O(n)
    // This will work with all the Integers
    // Dry run with [1, 0, 0, 1, 0] target = 1
    public int numSubArraysWithSumUsingHashMap(int[] nums, int goal) {
        int sum = 0, totalCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            Integer count = map.get(sum - goal);
            if (count != null) {
                totalCount += count;
            }
            map.merge(sum, 1, Integer::sum);
        }
        return totalCount;
    }
}
