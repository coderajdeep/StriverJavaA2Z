package __01__Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_31_4sum_18 {
    // Time complexity O(nlog(n) + n^3)
    // Space complexity O(1)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < (n-3); i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for(int j = i + 1; j < (n-2); j++) {
                if (j > (i + 1) && nums[j] == nums[j-1]) {
                    continue;
                }
                int start = j + 1;
                int end = n - 1;
                while (start < end) {
                    long sum = (long) nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) {
                        result.add(new ArrayList<> (List.of(nums[i], nums[j], nums[start], nums[end])));
                        start++;
                        end--;
                        while (start < end && nums[start] == nums[start-1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end+1]) {
                            end--;
                        }
                    }
                    else if (sum > target) {
                        end--;
                    }
                    else {
                        start++;
                    }
                }
            }
        }
        return result;
    }
}
