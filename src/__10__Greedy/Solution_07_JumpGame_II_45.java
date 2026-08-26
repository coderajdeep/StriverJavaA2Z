package __10__Greedy;

import java.util.Arrays;

public class Solution_07_JumpGame_II_45 {
    public int jumpBestGreedySolution(int[] nums) {
        int n = nums.length, jumps = 0, farthest = 0, currEnd = 0;
        for (int i=0; i<(n-1); i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (currEnd == i) {
                jumps++;
                currEnd = farthest;
            }
        }
        return jumps;
    }

    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return getCount(0, nums, dp);
    }
    private int getCount(int index, int[] nums, int[] dp) {
        if (index >= nums.length-1) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int minValue = Integer.MAX_VALUE;
        for (int i=1; i<=nums[index]; i++) {
            int next = getCount(index + i, nums, dp);
            if (next != Integer.MAX_VALUE) {
                minValue = Math.min(minValue, 1 + next);
            }
        }
        return dp[index] = minValue;
    }
}
