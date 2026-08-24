package __02__BinarySearch;

import java.util.Arrays;

public class Solution_21_AggressiveCows {
    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        int low = getMinDistance(nums), high = nums[nums.length - 1] - nums[0], mid, ans = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            int totalCows = totalCowsPossible(nums, mid);
            if (totalCows >= k) {
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }
    private int totalCowsPossible(int[] nums, int minDist) {
        int dist = 0, count = 1;
        for (int i=1; i<nums.length; i++) {
            dist += (nums[i] - nums[i-1]);
            if (dist >= minDist) {
                count++;
                dist = 0;
            }
        }
        return count;
    }
    private int getMinDistance(int[] nums) {
        int n = nums.length, minDistance = Integer.MAX_VALUE;
        for (int i=1; i<n; i++) {
            if ((nums[i] - nums[i-1]) < minDistance) {
                minDistance = nums[i] - nums[i-1];
            }
        }
        return minDistance;
    }
}
