package DP;

import java.util.ArrayList;
import java.util.List;

public class Solution_10_minFallingPathTriangle_120 {

    // Leetcode 120. Best Solution
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<Integer> dp = new ArrayList<>(triangle.get(n-1));
        for(int i=n-2; i>=0; i--) {
            for (int j=0; j<=i; j++) {
                int down = dp.get(j);
                int right = dp.get(j+1);
                int curr = triangle.get(i).get(j) + Math.min(down, right);
                dp.set(j, curr);
            }
        }
        return dp.get(0);
    }

    // Time complexity O(n^2)
    // Space complexity O(n) 1D array
    // Tabulation (Bottom up)
    public int minTriangleSumBestSolution(int[][] triangle) {
        int n = triangle.length;
        int[] dp = new int[n];
        System.arraycopy(triangle[n-1], 0, dp, 0, n);
        for(int i=n-2; i>=0; i--) {
            for (int j=0; j<=i; j++) {
                int down = dp[j];
                int right = dp[j+1];
                dp[j] = triangle[i][j] + Math.min(down, right);
            }
        }
        return dp[0];
    }

    // Time complexity O(n^2)
    // Space complexity O(n^2) 2D array
    // Tabulation (Bottom up)
    public int minTriangleSum(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = getDPArrayTabulation(n);
        System.arraycopy(triangle[n-1], 0, dp[n-1], 0, n);
        for(int i=n-2; i>=0; i--) {
            for (int j=0; j<=i; j++) {
                int down = dp[i+1][j];
                int right = dp[i+1][j+1];
                dp[i][j] = triangle[i][j] + Math.min(down, right);
            }
        }
        return dp[0][0];
    }

    private int[][] getDPArrayTabulation(int n) {
        // https://chatgpt.com/share/6a1d5b92-ebe8-8323-998c-c8c9d9baa758
        // Column size can be variable
        int[][] dp = new int[n][];
        for (int i=1; i <= n; i++) {
            dp[i-1] = new int[i];
        }
        return dp;
    }

    // Time complexity O(n^2)
    // Space complexity O(n^2) 2D array + Recursion function call stack O(n)
    // Memoization (Top down)
    public int minTriangleSumMemoization(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = getDPArrayMemoization(n);
        return getMin(0, 0, n, triangle, dp);
    }
    private int getMin(int i, int j, int n, int[][] triangle, int[][] dp) {
        if (i == (n-1)) {
            return triangle[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int right = getMin(i+1, j+1, n, triangle, dp);
        int down = getMin(i+1, j, n, triangle, dp);
        return dp[i][j] = Math.min(right, down) + triangle[i][j];
    }
    private int[][] getDPArrayMemoization(int n) {
        // https://chatgpt.com/share/6a1d5b92-ebe8-8323-998c-c8c9d9baa758
        // Column size can be variable
        int[][] dp = new int[n][];
        for (int i=1; i <= n; i++) {
            dp[i-1] = new int[i];
            for (int j=0; j<i; j++) {
                dp[i-1][j] = -1;
            }
        }
        return dp;
    }
}
