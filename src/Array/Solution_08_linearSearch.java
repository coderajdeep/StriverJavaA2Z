package Array;

public class Solution_08_linearSearch {
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int linearSearch(int[] nums, int target) {
        int size = nums.length;
        for (int i=0; i<size; ++i) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
