package __01__Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_34_MergeOverlappingIntervals_56 {
    // Leetcode version
    // Time complexity O(nlog(n) + n)
    // Space complexity O(1) - O(n) for storing answer
    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> temp = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for (int i=1; i<length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            }
            else {
                temp.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        temp.add(new int[] {start, end});
        int size = temp.size();
        int[][] result = new int[size][2];
        for (int i=0; i<size; i++) {
            result[i] = temp.get(i);
        }
        return result;
    }

    // https://chatgpt.com/share/69e8aeaa-ca58-8320-860d-96d5adb6ae37
    // Time complexity O(nlog(n) + n)
    // Space complexity O(1) - O(n) for storing answer
    public List<List<Integer>> mergeOverlap(List<List<Integer>> intervals) {
        Collections.sort(intervals, (a, b) -> Integer.compare(a.get(0), b.get(0)));
        // Similar
        // intervals.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));
        int size = intervals.size();
        int start = intervals.get(0).get(0), end = intervals.get(0).get(1);
        List<List<Integer>> result = new ArrayList<> ();
        for (int i=1; i<size; i++) {
            if (intervals.get(i).get(0) <= end) {
                end = Math.max(end, intervals.get(i).get(1));
            }
            else {
                result.add(new ArrayList<> (List.of(start, end)));
                start = intervals.get(i).get(0);
                end = intervals.get(i).get(1);
            }
        }
        result.add(new ArrayList<> (List.of(start, end)));
        return result;
    }
}
