package Greedy;

import java.util.Arrays;

public class Solution_04_ValidParenthesisChecker_678 {

    // https://youtu.be/cHT6sG_hUZI?t=1157
    public boolean isValidBestSolution(String s) {
        int max = 0, min = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                max++;
                min++;
            }
            else if (ch == ')') {
                max--;
                min--;
            }
            else {
                min--;
                max++;
            }
            if (min < 0) {
                if (max >= 0) {
                    min = 0;
                }
            }
            if (max < 0) {
                return false;
            }
        }
        return min == 0;
    }

    public boolean checkValidStringMemoization(String s) {
        int n = s.length(), count = n;
        int[][] dp = new int[n][count];
        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return check(s, 0, 0, dp) == 1;
    }
    private int check(String s, int index, int count, int[][] dp) {
        if (s.length() == index) {
            return count == 0 ? 1 : 0;
        }
        if (count < 0) {
            return -1;
        }
        if (dp[index][count] != -1) {
            return dp[index][count];
        }
        char ch = s.charAt(index);
        if (ch == '(') {
            return dp[index][count] = check(s, index+1, count+1, dp);
        }
        else if (ch == ')') {
            return dp[index][count] = check(s, index+1, count-1, dp);
        }
        else {
            return dp[index][count] = ((check(s, index+1, count-1, dp) == 1 || check(s, index+1, count+1, dp) == 1 || check(s, index+1, count, dp) == 1) ? 1 : 0);
        }
    }
}
