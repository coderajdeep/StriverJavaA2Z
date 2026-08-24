package __10__Greedy;

public class Solution_06_JumpGame_I_55 {
    public boolean canJump(int[] nums) {
        int n = nums.length, maxPossibleIndex = 0;
        for (int i=0; i<n; i++) {
            if (maxPossibleIndex < i) {
                return false;
            }
            maxPossibleIndex = Math.max(maxPossibleIndex, i + nums[i]);
            if (maxPossibleIndex >= n - 1) {
                return true;
            }
        }
        return true;
    }
}
