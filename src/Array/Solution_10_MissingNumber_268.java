package Array;

public class Solution_10_MissingNumber_268 {
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int missingNumber(int[] nums) {
        int missingNumber = 0, n = nums.length;
        for (int i=0; i<n; i++) {
            missingNumber = (missingNumber ^ (i+1) ^ nums[i]);
        }
        return missingNumber;
    }
}
