package __14__DP;

import java.util.Arrays;

public class Solution_16_CountSubsetSumEqualsK {
    private static final int MOD = 1_000_000_007;

    // Best solution
    // Time complexity O(n*target)
    // Space complexity O(target) 1D array
    // Tabulation (Bottom up)
    public int perfectSum(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[target+1];
        dp[0] = 1;
        if (target == 0 && arr[0] == 0) {
            dp[0] = 2;
        }
        else if (arr[0] <= target) {
            dp[arr[0]] = 1;
        }
        for (int i=1; i<n; i++) {
            // We need dp[j-arr[i]] value
            // So if we traverse j = 1 to target, then dp[j-arr[i]] will be updated
            // That's why need to traverse from j = target to 1
            for (int j=target; j>=0; j--) {
                int take = (arr[i] <= j) ? dp[j-arr[i]] : 0;
                int notTake = dp[j];
                dp[j] = (take + notTake) % MOD;
            }
        }
        return dp[target];
    }

    // Time complexity O(n*target)
    // Space complexity O(n*target) 2D array
    // Tabulation (Bottom up)
    public int perfectSumTabulation(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n][target+1];
        dp[0][0] = 1;
        if (target == 0 && arr[0] == 0) {
            dp[0][0] = 2;
        }
        else if (arr[0] <= target) {
            dp[0][arr[0]] = 1;
        }
        for (int i=1; i<n; i++) {
            for (int j=0; j<=target; j++) {
                int take = (arr[i] <= j) ? dp[i-1][j-arr[i]] : 0;
                int notTake = dp[i-1][j];
                dp[i][j] = (take + notTake) % MOD;
            }
        }
        return dp[n-1][target];
    }

    // Time complexity O(n*target)
    // Space complexity O(n*target) 2D array + Recursion function call stack O(n)
    // Memoization (Top down)
    public int perfectSumMemoization(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n][target+1];
        fill(n, dp);
        return getCount(n-1, target, arr, dp);
    }
    private int getCount(int index, int target, int[] arr, int[][] dp) {
        if (index == 0) {
            if (target == 0 && arr[0] == 0) {
                return 2;
            }
            else if (target == 0 || target == arr[0]) {
                return 1;
            }
            else {
                return 0;
            }
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        int take = (arr[index] <= target) ? getCount(index-1, target - arr[index], arr, dp) : 0;
        int notTake = getCount(index-1, target, arr, dp);
        return dp[index][target] = (take + notTake) % MOD;
    }
    private void fill(int n, int[][] dp) {
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
    }
}
