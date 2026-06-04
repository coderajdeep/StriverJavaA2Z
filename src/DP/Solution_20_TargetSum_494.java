package DP;

public class Solution_20_TargetSum_494 {
    private static final int MOD = 1_000_000_007;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int tar = Math.abs(target);
        // https://chatgpt.com/share/6a20c134-931c-8324-a4d1-2b90161c01ce
        // S1 + S2 = sum
        // abs(S1 - S2) = tar
        // To exist a solution, below two condition should be true
        // tar <= sum
        // (sum + tar) is even
        //
        // S1 = (sum + tar) / 2
        // S1 is one of the subset and should be integer
        // to exist S1, (sum + tar) should be even
        int value = sum + tar;
        int targetSum = value / 2;
        if (tar > sum || (value % 2 == 1)) {
            return 0;
        }
        return subsetSumCount(nums, targetSum);
    }

    private int subsetSumCount(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[target+1];
        dp[0] = 1;
        if (arr[0] == 0) {
            dp[0] = 2;
        }
        else if (arr[0] <= target) {
            dp[arr[0]] = 1;
        }
        for (int i=1; i<n; i++) {
            for (int j=target; j>=0; j--) {
                int take = (arr[i] <= j) ? dp[j-arr[i]] : 0;
                int notTake = dp[j];
                dp[j] = (take + notTake) % MOD;
            }
        }
        return dp[target];
    }
}
