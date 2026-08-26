package __10__Greedy;

import java.util.Arrays;

public class Solution_15_NonOverlappingInterval_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1, endTime = intervals[0][1], n = intervals.length;
        for (int i=1; i<n; i++) {
            if (endTime <= intervals[i][0]) {
                count++;
                endTime = intervals[i][1];
            }
        }
        return (n - count);
    }
}
