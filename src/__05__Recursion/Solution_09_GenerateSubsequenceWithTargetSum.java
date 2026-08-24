package __05__Recursion;

import java.util.ArrayList;
import java.util.List;

public class Solution_09_GenerateSubsequenceWithTargetSum {
    public static List<List<Integer>> getAllSubsequenceWithTargetSum(int[] nums, int sum) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        subsequenceUtils(0, nums.length, sum, nums, list, result);
        return result;
    }
    private static void subsequenceUtils(int index, int n, int sum, int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (index == n) {
            if (sum == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        // take
        if (nums[index] <= sum) {
            list.add(nums[index]);
            subsequenceUtils(index + 1, n, sum - nums[index], nums, list, result);
            list.remove(list.size() - 1);
        }
        // not take
        subsequenceUtils(index + 1, n, sum, nums, list, result);
    }
}
