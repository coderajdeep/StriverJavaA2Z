package __01__Array;

public class Solution_07_moveZerosToEnd_283 {
    // Time complexity: O(n)
    // Space complexity: O(1)
    public void moveZeroes(int[] nums) {
        int index = 0, n = nums.length;
        for (int i=0; i<n; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index++] = temp;
            }
        }
    }
}
