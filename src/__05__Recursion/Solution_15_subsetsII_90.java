package __05__Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_15_subsetsII_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list = new ArrayList<> ();
        List<List<Integer>> result = new ArrayList<> ();
        Arrays.sort(nums);
        subsetUtils(0, nums, list, result);
        return result;
    }
    private static void subsetUtils(int index, int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        // take
        list.add(nums[index]);
        subsetUtils(index + 1, nums, list, result);
        list.remove(list.size() - 1);
        // not take
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                subsetUtils(i, nums, list, result);
                return;
            }
        }
        subsetUtils(nums.length, nums, list, result);
    }
}
