package Array;

public class Solution_01_largestElementInArray {
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int largestElement(int[] nums) {
        int maxElement = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (maxElement < nums[i]) {
                maxElement = nums[i];
            }
        }
        return maxElement;
    }
}
