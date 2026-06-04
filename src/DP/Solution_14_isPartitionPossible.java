package DP;

public class Solution_14_isPartitionPossible {
    // Best Solution
    // Time complexity O(n*target)
    // Space complexity O(target) 1D array
    // Tabulation (Bottom up)
    public boolean equalPartition(int n, int[] arr) {
        int sum = 0;
        for (int element : arr) {
            sum += element;
        }
        // If sum is odd then it is not possible to partition into two equal subsets
        if (sum % 2 == 1) {
            return false;
        }
        return isSubsetSum(arr, sum/2);
    }

    private boolean isSubsetSum(int[] arr, int target) {
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
}
