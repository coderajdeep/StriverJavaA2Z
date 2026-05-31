package DP;

import java.util.Arrays;

public class Solution_06_HouseRobberII_213 {

    // Edge case -> n == 1
    // Edge case -> n == 2

    // Time complexity O(n)
    // Space complexity O(1)
    // Best Solution
    public int houseRobberIIBestSolution(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int excludeFirst = getMax(1, n-1, nums);
        int excludeLast = getMax(0, n-2, nums);
        return Math.max(excludeFirst, excludeLast);
    }
    private int getMax(int start, int endIndex, int[] nums) {
        int prev2 = 0, prev1 = nums[start], curr = nums[start];
        for(int i=start+1; i<=endIndex; i++) {
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
    public int houseRobberIITabulation(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int excludeFirst = getMaxTabulation(1, n-1, nums);
        int excludeLast = getMaxTabulation(0, n-2, nums);
        return Math.max(excludeFirst, excludeLast);
    }
    private int getMaxTabulation(int start, int endIndex, int[] nums) {
        int[] dp = new int[endIndex+1];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start], nums[start+1]);
        for(int i=start+2; i<=endIndex; i++) {
            int prevValue1 = dp[i-1];
            int prevValue2 = dp[i-2] + nums[i];
            dp[i] = Math.max(prevValue1, prevValue2);
        }
        return dp[endIndex];
    }



    // Time complexity O(n)
    // Space complexity O(n) -> 1D array + Recursion stack space
    // Memoization (Top down)
    public int houseRobberIIMemoization(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        int excludeFirst = getMaxMemoization(1, n-1, nums, dp1);
        int excludeLast = getMaxMemoization(0, n-2, nums, dp2);
        return Math.max(excludeFirst, excludeLast);
    }
    private int getMaxMemoization(int start, int index, int[] nums, int[] dp) {
        if (index < start) {
            return 0;
        }
        if (index == start) {
            return nums[start];
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int prev1 = getMaxMemoization(start, index-1, nums, dp);
        int prev2 = nums[index] + getMaxMemoization(start, index-2, nums, dp);
        return dp[index] = Math.max(prev1, prev2);
    }
}
