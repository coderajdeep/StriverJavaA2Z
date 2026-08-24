package __05__Recursion;

import java.util.ArrayList;
import java.util.List;

public class Solution_16_CombinationSumIII_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<> ();
        combinationUtils(0, k, n, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, list, result);
        return result;
    }
    private static void combinationUtils(int index, int k, int sum, int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (list.size() > k || sum < 0) {
            return;
        }
        if (list.size() == k && sum == 0) {
            result.add(new ArrayList<> (list));
            return;
        }
        if (index == nums.length) {
            return;
        }
        // take
        if (nums[index] <= sum) {
            list.add(nums[index]);
            combinationUtils(index + 1, k, sum - nums[index], nums, list, result);
            list.remove(list.size() - 1);
        }
        // not take
        combinationUtils(index + 1, k, sum, nums, list, result);
    }
}
