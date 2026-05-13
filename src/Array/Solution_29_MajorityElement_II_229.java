package Array;

import java.util.ArrayList;
import java.util.List;

public class Solution_29_MajorityElement_II_229 {
    // Time complexity O(n)
    // Space complexity O(1)
    public List<Integer> majorityElement(int[] nums) {
        int element1 = Integer.MAX_VALUE, element2 = Integer.MAX_VALUE, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == element1) {
                count1++;
            }
            else if (num == element2) {
                count2++;
            }
            else if (count1 == 0) {
                count1 = 1;
                element1 = num;
            }
            else if (count2 == 0) {
                count2 = 1;
                element2 = num;
            }
            else {
                count1--;
                count2--;
            }
        }
        return getMajorityElements(nums, element1, element2);
    }
    private List<Integer> getMajorityElements(int[] nums, int element1, int element2) {
        int count1 = 0, count2 = 0, n = nums.length;
        for (int num : nums) {
            if (num == element1) {
                count1++;
            }
            else if (num == element2) {
                count2++;
            }
        }
        List<Integer> list = new ArrayList<>();
        if (count1 > (n/3)) {
            list.add(element1);
        }
        if (count2 > (n/3)) {
            list.add(element2);
        }
        return list;
    }
}
