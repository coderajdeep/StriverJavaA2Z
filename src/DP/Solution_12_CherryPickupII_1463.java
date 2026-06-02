package DP;

import java.util.Arrays;

public class Solution_12_CherryPickupII_1463 {

    // Best Solution
    // Time complexity O(n*m*m*9)
    // Space complexity O(m*m) 2D array
    // Tabulation (Bottom up)
    public int maxChocolatesBestSolution(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] prev = new int[m][m];
        int[][] curr = new int[m][m];
        for (int i=0; i<m; i++) {
            for (int j=0; j<m; j++) {
                if (i == j) {
                    prev[i][j] = matrix[n-1][i];
                }
                else {
                    prev[i][j] = matrix[n-1][i] + matrix[n-1][j];
                }
            }
        }
        for (int index = n-2; index >= 0; index--) {
            for (int i=0; i<m; i++) {
                for (int j=0; j<m; j++) {
                    int maxValue = Integer.MIN_VALUE;
                    for (int c1 = -1; c1 <= 1; c1++) {
                        for (int c2 = -1; c2 <= 1; c2++) {
                            int col1 = i + c1;
                            int col2 = j + c2;
                            if (col1 >=0 && col1 < m && col2 >=0 && col2 < m) {
                                maxValue = Math.max(maxValue, prev[col1][col2]);
                            }
                        }
                    }
                    if (i == j) {
                        maxValue += matrix[index][i];
                    }
                    else {
                        maxValue += (matrix[index][i] + matrix[index][j]);
                    }
                    curr[i][j] = maxValue;
                }
            }
            copy(m, curr, prev);
        }
        return prev[0][m-1];
    }
    private void copy(int m, int[][] source, int[][] dest) {
        for (int i=0; i<m; i++) {
            System.arraycopy(source[i], 0, dest[i], 0, m);
        }
    }


    // Time complexity O(n*m*m*9)
    // Space complexity O(n*m*m) 3D array + Recursion function call stack O(n)
    // Tabulation (Bottom up)
    public int maxChocolatesTabulation(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][][] dp = new int[n][m][m];
        fill(n, m, dp);
        for (int i=0; i<m; i++) {
            for (int j=0; j<m; j++) {
                if (i == j) {
                    dp[n-1][i][j] = matrix[n-1][i];
                }
                else {
                    dp[n-1][i][j] = matrix[n-1][i] + matrix[n-1][j];
                }
            }
        }
        for (int index = n-2; index >= 0; index--) {
            for (int i=0; i<m; i++) {
                for (int j=0; j<m; j++) {
                    int maxValue = Integer.MIN_VALUE;
                    for (int c1 = -1; c1 <= 1; c1++) {
                        for (int c2 = -1; c2 <= 1; c2++) {
                            int col1 = i + c1;
                            int col2 = j + c2;
                            if (col1 >=0 && col1 < m && col2 >=0 && col2 < m) {
                                maxValue = Math.max(maxValue, dp[index+1][col1][col2]);
                            }
                        }
                    }
                    if (i == j) {
                        maxValue += matrix[index][i];
                    }
                    else {
                        maxValue += (matrix[index][i] + matrix[index][j]);
                    }
                    dp[index][i][j] = maxValue;
                }
            }
        }
        return dp[0][0][m-1];
    }
    private void fill(int n, int m, int[][][] dp) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
    }

    // Time complexity O(n*m*m*9)
    // Space complexity O(n*m*m) 3D array + Recursion function call stack O(n)
    // Memoization (Top down)
    public int cherryPickup(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][][] dp = new int[n][m][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return getMax(0, 0, m-1, n, m, matrix, dp);
    }
    private int getMax(int row, int col1, int col2, int n, int m, int[][] matrix, int[][][] dp) {
        if (row == n-1) {
            if (col1 == col2) {
                return matrix[row][col1];
            }
            else {
                return matrix[row][col1] + matrix[row][col2];
            }
        }
        if (dp[row][col1][col2] != -1) {
            return dp[row][col1][col2];
        }
        int maxValue = Integer.MIN_VALUE;
        for (int i=-1; i<=1; i++) {
            for (int j=-1; j<=1; j++) {
                int c1 = col1+i;
                int c2 = col2+j;
                if (c1 >= 0 && c1 < m && c2 >= 0 && c2 < m) {
                    maxValue = Math.max(maxValue, getMax(row+1, c1, c2, n, m, matrix, dp));
                }
            }
        }
        maxValue += ((col1 == col2) ? matrix[row][col1] : matrix[row][col1] + matrix[row][col2]);
        return dp[row][col1][col2] = maxValue;
    }
}
