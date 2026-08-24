package __14__DP;

public class Solution_07_NinjaTraining_PaintHouse_256 {
    // Note: this implements takeUforward's generalized "Ninja's Training" (m activities, maximize points),
    // not LeetCode #256 "Paint House" (fixed 3 colors, minimize cost) despite the filename suffix.

    // Function(day, lastTask) -> Maximum merit points that can be earned from day 0 to day 'day',
    // given that 'lastTask' was performed on the next day (day + 1) and therefore cannot be chosen on the current day.

    // Function(day, lastTask) -> Maximum points that can be earned up to 'day'
    // when task 'lastTask' is not allowed on the current day.

    // dp[day][lastTask] = Maximum points obtainable from days 0..day,
    // where 'lastTask' represents the task performed on the previous day relative to the current state
    // (i.e., the task that cannot be chosen on day 'day').


    // Best Solution
    // Time complexity O(n*m*m)
    // Space complexity O(m) 1D array
    public int ninjaTrainingBestSolution(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] curr = new int[m+1];
        int[] prev = new int[m+1];

        // Can't perform task or current day
        for (int task = 0; task <= m; task++) {
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                if (task != i) {
                    maxValue = Math.max(maxValue, matrix[0][i]);
                }
            }
            prev[task] = maxValue;
        }
        for (int index = 1; index < n; index++) {
            // Can't perform task or current day
            for (int task = 0; task <= m; task++) {
                int maxValue = Integer.MIN_VALUE;
                for (int i = 0; i < m; i++) {
                    if (task != i) {
                        maxValue = Math.max(maxValue, prev[i] + matrix[index][i]);
                    }
                }
                curr[task] = maxValue;
            }
            System.arraycopy(curr, 0, prev, 0, m + 1);
        }
        return prev[m];
    }

    // Time complexity O(n*m*m)
    // Space complexity O(n*m) 2D array
    // Tabulation (Bottom up)
    public int ninjaTraining(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m+1];
        // Can't perform task or current day
        for (int task = 0; task <= m; task++) {
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                if (task != i) {
                    maxValue = Math.max(maxValue, matrix[0][i]);
                }
            }
            dp[0][task] = maxValue;
        }
        for (int index = 1; index < n; index++) {
            // Can't perform task on current day
            for (int task = 0; task <= m; task++) {
                int maxValue = Integer.MIN_VALUE;
                for (int i = 0; i < m; i++) {
                    if (task != i) {
                        maxValue = Math.max(maxValue, dp[index-1][i] + matrix[index][i]);
                    }
                }
                dp[index][task] = maxValue;
            }
        }
        return dp[n-1][m];
    }



    // Time complexity O(n*m*m)
    // Space complexity O(n*m) 2D array + O(n) Recursion stack space
    // Memoization (Top down)
    public int ninjaTrainingMemoization(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m+1];
        fill(n, m, dp);
        return getMaxPoint(n-1, m, matrix, dp);
    }
    private int getMaxPoint(int index, int task, int[][] matrix, int[][] dp) {
        if (index == 0) {
            int maxValue = Integer.MIN_VALUE;
            for (int i=0; i<matrix[0].length; i++) {
                if (i != task) {
                    maxValue = Math.max(maxValue, matrix[index][i]);
                }
            }
            return maxValue;
        }
        if (dp[index][task] != -1) {
            return dp[index][task];
        }
        int maxValue = Integer.MIN_VALUE;
        for (int i=0; i<matrix[0].length; i++) {
            if (i != task) {
                int value = matrix[index][i] + getMaxPoint(index-1, i, matrix, dp);
                maxValue = Math.max(maxValue, value);
            }
        }
        return dp[index][task] = maxValue;
    }
    private void fill(int n, int m, int[][] dp) {
        for (int i=0; i < n; i++) {
            for (int j=0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
    }
}
