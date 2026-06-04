package DP;

import java.util.Arrays;

public class Solution_13_SubsetSum {

    // Best Solution
    // Time complexity O(n*target)
    // Space complexity O(target) 1D array
    // Tabulation (Bottom up)
    public boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        if (arr[0] <= target) {
            dp[arr[0]] = true;
        }
        for (int i=1; i<n; i++) {
            // as dp[j - arr[i]] is required
            // If traverse j = 1 to target then dp[j - arr[i]] will be updated
            for (int j=target; j>=1; j--) {
                boolean take = false;
                if (arr[i] <= j) {
                    take = dp[j - arr[i]];
                }
                boolean notTake = dp[j];
                dp[j] = (take || notTake);
            }
        }
        return dp[target];
    }

    // Time complexity O(n*target)
    // Space complexity O(n*target) 2D array
    // Tabulation (Bottom up)
    public boolean isSubsetSumTabulation(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][target+1];
        dp[0][0] = true;
        if (arr[0] <= target) {
            dp[0][arr[0]] = true;
        }
        for (int i=1; i<n; i++) {
            dp[i][0] = true;
            for (int j=1; j<=target; j++) {
                boolean take = false;
                if (arr[i] <= j) {
                    take = dp[i-1][j - arr[i]];
                }
                boolean notTake = dp[i-1][j];
                dp[i][j] = (take || notTake);
            }
        }
        return dp[n-1][target];
    }

    // Time complexity O(n*target)
    // Space complexity O(n*target) 2D array + Recursion function call stack O(n)
    // Memoization (Top down)
    public boolean isSubsetSumMemoization(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n][target+1];
        fill(n, dp);
        return (isValid(n-1, target, arr, dp) == 1);
    }
    private int isValid(int index, int target, int[] arr, int[][] dp) {
        if (target == 0) {
            return 1;
        }
        if (index == 0) {
            if (arr[0] == target) {
                return 1;
            }
            else {
                return 0;
            }
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        int take = (arr[index] <= target) ? isValid(index-1, target - arr[index], arr, dp) : 0;
        int notTake = isValid(index-1, target, arr, dp);
        return dp[index][target] = (take == 1 || notTake == 1) ? 1 : 0;
    }
    private void fill(int n, int[][] dp) {
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
    }
}
