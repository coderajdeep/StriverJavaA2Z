package __01__Array;

import java.util.HashMap;
import java.util.Map;

public class Solution_33_LargestSubArrayWithGivenXOR {
    public static int largestSubArraysWithXorK(int[] nums, int k) {
        int n = nums.length, xor = 0, maxLength = 0;
        Map<Integer, Integer> prefixXOR = new HashMap<>();
        prefixXOR.put(0, -1);
        for (int i=0; i<n; i++) {
            xor ^= nums[i];
            Integer index = prefixXOR.get(xor ^ k);
            if (index != null) {
                maxLength = Math.max(maxLength, i - index);
            }
            if (!prefixXOR.containsKey(xor)) {
                prefixXOR.put(xor, i);
            }
        }
        return maxLength;
    }
}
