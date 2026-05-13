package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_13_CombinationSumII_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<> ();
        Arrays.sort(candidates);
        sumUtils(0, target, candidates, list, result);
        return result;
    }
    private static void sumUtils(int index, int target, int[] candidates, List<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<> (list));
            return;
        }
        if (index == candidates.length) {
            return;
        }
        // take
        if (candidates[index] <= target) {
            list.add(candidates[index]);
            sumUtils(index + 1, target - candidates[index], candidates, list, result);
            list.remove(list.size() - 1);
        }
        // Will not take the candidates[index] as well as same value
        for (int i=index+1; i<candidates.length; i++) {
            if (candidates[i-1] != candidates[i]) {
                // not taking next first element which is not equal to candidates[index]
                sumUtils(i, target, candidates, list, result);
                break;
            }
        }
    }
}
