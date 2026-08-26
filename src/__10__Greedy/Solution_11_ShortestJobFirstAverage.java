package __10__Greedy;

import java.util.Arrays;

public class Solution_11_ShortestJobFirstAverage {
    public long solve(int[] bt) {
        Arrays.sort(bt);
        long totalTime = 0, time = 0, n = bt.length;
        for (int i = 0; i < (n-1); i++) {
            time += bt[i];
            totalTime += time;
        }
        return (int)(totalTime / n);
    }
}
