package __05__Recursion;

import java.util.ArrayList;
import java.util.List;

public class Solution_14_subsetsI {
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> result = new ArrayList<>();
        subsetUtils(0, 0, nums, result);
        return result;
    }
    private static void subsetUtils(int index, int sum, int[] nums, List<Integer> result) {
        if (index == nums.length) {
            result.add(sum);
            return;
        }
        // take
        subsetUtils(index + 1, sum + nums[index], nums, result);
        // not take
        subsetUtils(index + 1, sum, nums, result);
    }
}
