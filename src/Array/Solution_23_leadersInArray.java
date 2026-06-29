package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_23_leadersInArray {
    // Time complexity O(n)
    // Space complexity O(n) // For storing the answer
    public List<Integer> leaders(int[] nums) {
        int size = nums.length, maxElement = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int i=size-1; i >= 0; i--) {
            if (maxElement < nums[i]) {
                list.add(nums[i]);
                maxElement = nums[i];
            }
        }
        Collections.reverse(list);
        return list;
    }
}
