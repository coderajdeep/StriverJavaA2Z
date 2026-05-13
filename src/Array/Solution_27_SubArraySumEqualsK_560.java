package Array;

import java.util.HashMap;
import java.util.Map;

public class Solution_27_SubArraySumEqualsK_560 {
    public int subArraySum(int[] nums, int k) {
        Map<Long, Integer> hash = new HashMap<>();
        hash.put(0L, 1);
        long sum = 0L;
        int totalCount = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            Integer count = hash.get(sum - k);
            if (count != null) {
                totalCount += count;
            }
            hash.merge(sum, 1, Integer::sum);
        }
        return totalCount;
    }
}
