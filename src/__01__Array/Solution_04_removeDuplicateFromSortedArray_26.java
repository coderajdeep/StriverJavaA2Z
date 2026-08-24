package __01__Array;

public class Solution_04_removeDuplicateFromSortedArray_26 {
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n==1) {
            return n;
        }
        int index = 1;
        for (int i=1; i<n; i++) {
            if (nums[i-1] != nums[i]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
