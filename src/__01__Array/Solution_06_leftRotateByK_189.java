package __01__Array;

public class Solution_06_leftRotateByK_189 {
    // Time complexity: O(n)
    // Space complexity: O(1)
    // Note: this rotates LEFT by k; LeetCode #189 "Rotate Array" asks for a RIGHT rotation by k.
    public void rotateArray(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if (len == 1 || k == 0) return;
        reverse(nums, 0, k-1);
        reverse(nums, k, len-1);
        reverse(nums, 0, len-1);
    }
    private void reverse(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
            ++startIndex;
            --endIndex;
        }
    }
}
