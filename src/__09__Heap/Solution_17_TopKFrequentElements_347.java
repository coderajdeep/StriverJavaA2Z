package __09__Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_17_TopKFrequentElements_347 {
    // https://youtu.be/GLw4WbJdYLw
    // Time complexity O(n+k)
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        List<Integer>[] freq = new ArrayList[n+1];
        for (int i=0; i<=n; i++) {
            freq[i] = new ArrayList<> ();
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }
        int[] result = new int[k];
        int count = 0;
        for (int i=n; i>=0; i--) {
            for (int element : freq[i]) {
                result[count++] = element;
                if (count == k) {
                    return result;
                }
            }
        }
        return result;
    }
}
