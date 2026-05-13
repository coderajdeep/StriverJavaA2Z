package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Solution_12_CombinationSum_39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<> ();
        List<List<Integer>> result = new ArrayList<> ();
        sumUtils(0, target, candidates, list, result);
        return result;
    }
    private static void sumUtils(int index, int target, int[] candidates, List<Integer> list, List<List<Integer>> result) {
        if (index == candidates.length) {
            if (target == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        // take
        if (candidates[index] <= target) {
            list.add(candidates[index]);
            sumUtils(index, target - candidates[index], candidates, list, result);
            list.remove(list.size() - 1);
        }
        // not take
        sumUtils(index + 1, target, candidates, list, result);
    }
}
