package __10__Greedy;

import java.util.Arrays;

public class Solution_Q1_MeetingRooms_252 {
    public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return true;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int endTime = intervals[0][1];
        for (int i=1; i<n; i++) {
            if (endTime > intervals[i][0]) {
                return false;
            }
            endTime = intervals[i][1];
        }
        return true;
    }
}
