package DP;

public class Solution_17_CountPartitionWithGivenDiff {
    // Best Solution
    // Time complexity O(n*target)
    // Space complexity O(target) 1D array
    // Tabulation (Bottom up)
    private static final int MOD = 1_000_000_007;
    public int countPartitions(int n, int diff, int[] arr) {
        int sum = 0;
        for (int i=0; i<n; i++) {
            sum += arr[i];
        }
        int value = sum + diff;
        int target = value / 2;
        if (target > sum || (value % 2 == 1)) {
            return 0;
        }
        return subsetSumCount(arr, target);
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
