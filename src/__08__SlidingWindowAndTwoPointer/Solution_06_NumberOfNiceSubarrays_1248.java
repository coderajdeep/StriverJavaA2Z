package __08__SlidingWindowAndTwoPointer;

public class Solution_06_NumberOfNiceSubarrays_1248 {
    // Similar to Solution_05_BinarySubArrayWithGivenSum_930
    // Number of subarray with given sum (elements and sum are non-negative)
    // Time complexity O(2*n)
    // Space complexity O(1)
    public int numberOfOddSubarrays(int[] nums, int k) {
        return (int) (numOfSubArraysWithAtMostGivenSum(nums, k) - numOfSubArraysWithAtMostGivenSum(nums, k-1));
    }
    public long numOfSubArraysWithAtMostGivenSum(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }
        int left = 0, right = 0, sum = 0;
        long count = 0;
        while (right < nums.length) {
            sum += (nums[right] % 2 == 1 ? 1 : 0);
            while (left <= right && sum > goal) {
                sum -= (nums[left] % 2 == 1 ? 1 : 0);
                ++left;
            }
            // sum -> window sum between left and right inclusive
            // count -> total subarray having sum <= k and subarray is ending at index right
            count += (right - left + 1);
            ++right;
        }
        return count;
    }
}
