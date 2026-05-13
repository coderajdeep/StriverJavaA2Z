package Array;

import java.util.HashMap;
import java.util.Map;

public class Solution_33_SubArrayCountWithGivenXOR {
    public int subArraysWithXorK(int[] nums, int k) {
        int n = nums.length, xor = 0, totalCount = 0;
        Map<Integer, Integer> prefixXOR = new HashMap<>();
        prefixXOR.put(0, 1);
        for (int i=0; i<n; i++) {
            xor ^= nums[i];
            Integer count = prefixXOR.get(xor ^ k);
            if (count != null) {
                totalCount += count;
            }
            prefixXOR.merge(xor, 1, Integer::sum);
        }
        return totalCount;
    }
}
