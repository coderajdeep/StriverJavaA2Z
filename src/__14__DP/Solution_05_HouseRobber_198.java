package __14__DP;

import java.util.Arrays;

public class Solution_05_HouseRobber_198 {

    // Time complexity O(n)
    // Space complexity O(1)
    // Best Solution
    public int nonAdjacentBestSolution(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        // prev2 (when index is less than 0) -> 0
        // prev1 (index is 0) -> nums[0]
        // curr (index value (n-1))
        // curr -> 0 is not appropriate
        // It's kind of placeholder because we need to assign value
        int prev2 = 0, prev1 = nums[0], curr = 0;
        for (int i=1; i<n; i++) {
            int prevValue1 = prev1;
            int prevValue2 = prev2 + nums[i];
            curr = Math.max(prevValue1, prevValue2);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }

    // Time complexity O(n)
    // Space complexity O(n) -> 1D array
    // Tabulation (Bottom up)
    public int nonAdjacentTabulation(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        if (n == 1) {
            return dp[0];
        }
        dp[1] = Math.max(nums[0], nums[1]);
        if (n == 2) {
            return dp[1];
        }
        for (int i=2; i<n; i++) {
            int prev1 = dp[i-1];
            int prev2 = dp[i-2] + nums[i];
            dp[i] = Math.max(prev1, prev2);
        }
        return dp[n-1];
    }

    // Time complexity O(n)
    // Space complexity O(n) -> 1D array + Recursion stack space
    // Memoization (Top down)
    public int nonAdjacentMemoization(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return getMax(n-1, nums, dp);
    }
    private int getMax(int index, int[] nums, int[] dp) {
        if (index < 0) {
            return 0;
        }
        if (index == 0) {
            return nums[0];
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int prev1 = getMax(index-1, nums, dp);
        int prev2 = nums[index] + getMax(index-2, nums, dp);
        return dp[index] = Math.max(prev1, prev2);
    }
}
