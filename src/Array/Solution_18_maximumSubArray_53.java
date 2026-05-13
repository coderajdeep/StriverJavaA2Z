package Arrays;

public class Solution_18_maximumSubArray_53 {
    public int maxSubArray(int[] nums) {
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            if ((currSum + num) < num) {
                currSum = num;
            } else {
                currSum += num;
            }
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
