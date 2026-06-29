package Array;

import java.util.HashSet;
import java.util.Set;

public class Solution_24_longestConsecutiveElements_128 {
    // Time complexity O(n)
    // Space complexity O(n)
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 0;
        for (int num : nums) {
            if (!set.contains(num-1)) {
                int next = num + 1, length = 1;
                while (set.contains(next)) {
                    length++;
                    next++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
}
