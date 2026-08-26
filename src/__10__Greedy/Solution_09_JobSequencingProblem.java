package __10__Greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_09_JobSequencingProblem {
    public int[] JobScheduling(int[][] Jobs) {
        Arrays.sort(Jobs, (a, b) -> Integer.compare(b[2], a[2]));
        Set<Integer> set = new HashSet<>();
        int n = Jobs.length, count = 0, total = 0;
        for (int i=0; i<n; i++) {
            int day = Jobs[i][1];
            for (int j=day; j>=1; j--) {
                if (!set.contains(j)) {
                    count++;
                    total += Jobs[i][2];
                    set.add(j);
                    break;
                }
            }
        }
        return new int[] {count, total};
    }
}
