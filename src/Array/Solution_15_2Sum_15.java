package Arrays;

import java.util.HashMap;
import java.util.Map;

public class Solution_15_2Sum_15 {
    // Time complexity O(n)
    // Space complexity O(n)
    public int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<size; ++i) {
            Integer leftIndex = map.get(target - nums[i]);
            if (leftIndex != null) {
                return new int[] {leftIndex, i};
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}
