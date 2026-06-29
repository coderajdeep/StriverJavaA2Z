package Array;

public class Solution_11_MaxConsecutiveOne_485 {
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length, count = 0, maxCount = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }
}
