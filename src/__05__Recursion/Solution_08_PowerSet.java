package __05__Recursion;

import java.util.ArrayList;
import java.util.List;

public class Solution_08_PowerSet {
    public List<List<Integer>> powerSet(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<> ();
        powerSetUtils(0, nums, list, result);
        return result;
    }
    private static void powerSetUtils(int index, int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (index == nums.length) {
            // Need to create a new list
            result.add(new ArrayList(list));
            return;
        }
        // not take
        powerSetUtils(index + 1, nums, list, result);

        // take
        list.add(nums[index]);
        powerSetUtils(index + 1, nums, list, result);
        list.remove(list.size() - 1);
    }
}
