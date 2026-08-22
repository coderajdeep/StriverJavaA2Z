package Greedy;

import java.util.Arrays;

public class Solution_01_AssignCookies_455 {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length, m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, count = 0;
        while (i < n && j < m) {
            if (g[i] <= s[j]) {
                count++;
                i++;
                j++;
            }
            else {
                j++;
            }
        }
        return count;
    }
}
