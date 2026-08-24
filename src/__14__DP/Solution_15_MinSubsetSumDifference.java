package __14__DP;

public class Solution_15_MinSubsetSumDifference {
    // Best Solution
    // Time complexity O(n*target)
    // Space complexity O(target) 1D array
    // Tabulation (Bottom up)
    public int minDifference(int[] arr, int n) {
        int sum = 0;
        for (int element : arr) {
            sum += element;
        }
        boolean[] isSubset = subsetSum(arr, sum);
        int minDiff = Integer.MAX_VALUE;
        // Only iterate till sum/2 because subset sums beyond sum/2
        // produce the same partition difference symmetrically.
        for (int i=0; i<=(sum/2); i++) {
            if (isSubset[i]) {
                minDiff = Math.min(minDiff, Math.abs(sum - 2*i));
            }
        }
        return minDiff;
    }
    private boolean[] subsetSum(int[] arr, int target) {
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
        return dp;
    }
}
