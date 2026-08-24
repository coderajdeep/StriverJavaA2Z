package __01__Array;

import java.util.HashMap;
import java.util.Map;

public class Solution_32_LargestSubArrayWithGivenSum {
    // Note: no target sum parameter — this looks up `sum` itself in the prefix map,
    // so it actually finds the largest subarray with sum 0, not an arbitrary given sum.
    public int maxLen(int[] arr) {
        int n = arr.length, maxLength = 0;
        long sum = 0;
        Map<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0L, -1);
        for (int i=0; i<n; i++) {
            sum += arr[i];
            Integer index = prefixSum.get(sum);
            if (index != null) {
                maxLength = Math.max(maxLength, i - index);
            }
            if (!prefixSum.containsKey(sum)) {
                prefixSum.put(sum, i);
            }
        }
        return maxLength;
    }
}
