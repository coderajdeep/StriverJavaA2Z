package __10__Greedy;

import java.util.ArrayList;
import java.util.List;

public class Solution_13_InsertInterval_57 {
    public int[][] insertBestSolution(int[][] intervals, int[] newInterval) {
        int n = intervals.length, i = 0;
        List<int[]> result = new ArrayList<> ();
        // before overlapping interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }
        // overlapping interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        while (i < n) {
            result.add(intervals[i++]);
        }
        return result.toArray(new int[0][]);
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) {
            return new int[][] {newInterval};
        }
        List<int[]> list = new ArrayList<>();
        if (newInterval[0] < intervals[0][0]) {
            list.add(newInterval);
        }
        for (int i=0; i<n-1; i++) {
            list.add(intervals[i]);
            if (intervals[i][0] <= newInterval[0] && newInterval[0] <= intervals[i+1][0]) {
                list.add(newInterval);
            }
        }
        list.add(intervals[n-1]);
        if (intervals[n-1][0] <= newInterval[0]) {
            list.add(newInterval);
        }
        List<int[]> result = new ArrayList<> ();
        int start = list.get(0)[0], end = list.get(0)[1], len = list.size();
        for (int i=1; i<len; i++) {
            if (list.get(i)[0] <= end) {
                end = Math.max(end, list.get(i)[1]);
            }
            else {
                result.add(new int[] {start, end});
                start = list.get(i)[0];
                end = list.get(i)[1];
            }
        }
        result.add(new int[] {start, end});
        return result.toArray(new int[0][]);
    }
}
