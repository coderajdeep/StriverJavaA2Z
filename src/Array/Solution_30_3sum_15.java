package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_30_3sum_15 {
    // Time complexity O(nlog(n) + n^2)
    // Space complexity O(1)
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        int N = n - 2;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<N; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                    while (start < end && nums[start] == nums[start-1]) {
                        start++;
                    }
                    while (start < end && nums[end] == nums[end+1]) {
                        end--;
                    }
                }
                else if (sum > 0) {
                    end--;
                }
                else {
                    start++;
                }
            }
        }
        return result;
    }
}
