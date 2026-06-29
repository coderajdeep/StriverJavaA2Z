package SlidingWindowAndTwoPointer;

public class Solution_02_Max_Consecutive_Ones_III_1004 {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, length = nums.length, maxCount = 0, count = 0, flipCount = 0;
        while (right < length) {
            if (nums[right] == 1 || flipCount < k) {
                maxCount = Math.max(maxCount, right - left + 1);
                if (nums[right] == 0) {
                    flipCount++;
                }
                right++;
            }
            else {
                if (nums[left] == 0) {
                    flipCount--;
                }
                ++left;
                // For this section we can't increase right
                // simple example
                // [1, 1, 1, 0, 0, 0, 1, 1] k = 2
                // In 5th index, we can't increase right
                // If we do increase right then 1 1 1 0 0 0 1 and 1 1 1 0 0 0 1 1 will be considered valid window

                // [0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1]
                // Actual output if we increase right : 15
                // expected output : 9
                //
                // This is happening because in 9th index
                // we are not increasing flipCount although the value is 0
                // it's should increase
            }
        }
        return maxCount;
    }
}
