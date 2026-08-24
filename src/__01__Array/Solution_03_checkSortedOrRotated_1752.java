package __01__Array;

public class Solution_03_checkSortedOrRotated_1752 {
    // Time complexity: O(n)
    // Space complexity: O(1)
    public boolean check(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return true;
        }
        int count = 0;
        for (int i=1; i<n; i++) {
            if (nums[i-1] > nums[i]) {
                count++;
            }
        }
        if (count == 0) {
            return true;
        }
        if (count > 1) {
            return false;
        }
        return nums[0] >= nums[n-1];
    }
}
