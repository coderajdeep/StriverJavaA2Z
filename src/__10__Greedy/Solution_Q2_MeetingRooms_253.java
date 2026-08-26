package __10__Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_Q2_MeetingRooms_253 {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> meetings = new ArrayList<>();
        for (int[] interval : intervals) {
            meetings.add(new int[] {interval[0], 0});
            meetings.add(new int[] {interval[1], 1});
        }

        Collections.sort(meetings, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int maxRoomRequired = 0, count = 0;
        for (int[] meeting : meetings) {
            if (meeting[1] == 0) {
                count++;
            }
            else {
                count--;
            }
            maxRoomRequired = Math.max(maxRoomRequired, count);
        }
        return maxRoomRequired;
    }
}
