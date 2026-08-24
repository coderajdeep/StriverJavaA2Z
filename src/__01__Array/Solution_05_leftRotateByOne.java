package __01__Array;

public class Solution_05_leftRotateByOne {
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void rotateArrayByOne(int[] nums) {
        int len = nums.length;
        if (len == 1) return;
        int firstElement = nums[0];
        for(int i=1; i<len; ++i) {
            nums[i-1] = nums[i];
        }
        nums[len-1] = firstElement;
    }
}
