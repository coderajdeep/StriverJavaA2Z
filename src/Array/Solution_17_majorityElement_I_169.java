package Array;

import java.util.HashMap;
import java.util.Map;

public class Solution_17_majorityElement_I_169 {
    // Time complexity O(n)
    // Space complexity O(1)
    public int majorityElementBestSolution(int[] nums) {
        int size = nums.length, count = 0, element = Integer.MAX_VALUE;
        for (int i=0; i<size; i++) {
            if (element == nums[i]) {
                count++;
            }
            else if (count == 0) {
                count = 1;
                element = nums[i];
            }
            else {
                count--;
            }
        }
        // We need to do this below when we need to check the existence of majority element
        // int freq = getCount(nums, element);
        // return freq > (size/2) ? element : -1;

        // Given that there will be always a majority element
        return element;
    }
    private int getCount(int[] nums, int element) {
        int count = 0;
        for (int num : nums) {
            if (element == num) {
                count++;
            }
        }
        return count;
    }

    // Time complexity O(n)
    // Space complexity O(n)
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
            if (map.get(num) > (nums.length / 2)) {
                return num;
            }
        }
        return -1;
    }
}
