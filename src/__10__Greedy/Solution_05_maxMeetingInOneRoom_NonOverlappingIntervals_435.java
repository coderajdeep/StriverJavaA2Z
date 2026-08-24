package __10__Greedy;

import java.util.Arrays;

public class Solution_05_maxMeetingInOneRoom_NonOverlappingIntervals_435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length, count = 1, end = intervals[0][1];
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        for (int i=1; i<n; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return (n - count);
    }

    private static class Meeting {
        int start;
        int end;
        Meeting(int s, int e) {
            start = s;
            end = e;
        }
    }
    public int maxMeetingsCleanImplementation(int[] start, int[] end) {
        int n = start.length;
        Meeting[] meeting = new Meeting[n];
        for (int i=0; i<n; i++) {
            meeting[i] = new Meeting(start[i], end[i]);
        }
        Arrays.sort(meeting, (a, b) -> {
            if (a.end == b.end) {
                return Integer.compare(a.start, b.start);
            }
            return Integer.compare(a.end, b.end);
        });
        int count = 1, endVal = meeting[0].end;
        for (int i=1; i<n; i++) {
            if (meeting[i].start > endVal) {
                endVal = meeting[i].end;
                count++;
            }
        }
        return count;
    }
    public int maxMeetingsSimpleImplementation(int[] start, int[] end) {
        int n = start.length;
        int[][] meeting = new int[n][2];
        for (int i=0; i<n; i++) {
            meeting[i] = new int[]{start[i], end[i]};
        }
        Arrays.sort(meeting, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1, endVal = meeting[0][1];
        for (int i=1; i<n; i++) {
            if (meeting[i][0] > endVal) {
                endVal = meeting[i][1];
                count++;
            }
        }
        return count;
    }
}
