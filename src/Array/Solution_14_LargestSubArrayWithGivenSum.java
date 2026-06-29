package Array;

import java.util.HashMap;
import java.util.Map;

public class Solution_14_LargestSubArrayWithGivenSum {
    // This will work with negative numbers as well
    // Time complexity O(n)
    // Space complexity O(1)
    public int longestSubArrayWithGivenSum(int[] nums, int k) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        long sum = 0;
        int maxLength = 0, n = nums.length;
        for (int i=0; i<n; i++) {
            sum += nums[i];
            Integer index = map.get(sum - k);
            if (index != null) {
                maxLength = Math.max(maxLength, i - index);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLength;
    }
}
