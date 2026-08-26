package __10__Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_14_MergeInterval_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int startTime = intervals[0][0], endTime = intervals[0][1];
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] <= endTime) {
                endTime = Math.max(endTime, intervals[i][1]);
            }
            else {
                result.add(new int[] {startTime, endTime});
                startTime = intervals[i][0];
                endTime = intervals[i][1];
            }
        }
        result.add(new int[] {startTime, endTime});
        return result.toArray(new int[0][]);
    }
}
