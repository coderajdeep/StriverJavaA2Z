package __01__Array;

public class Solution_39_maxProductSubArray_152 {
    public int maxProduct(int[] nums) {
        int leftProduct = 1, rightProduct = 1, maxProduct = Integer.MIN_VALUE, n = nums.length;
        // edge case
        // [1,0,-1,2,3,-5,-2]
        for (int i=0; i<n; i++) {
            if (nums[i] != 0) {
                leftProduct = (leftProduct * nums[i]);
                maxProduct = Math.max(maxProduct, leftProduct);
            }
            else {
                maxProduct = Math.max(maxProduct, 0);
                leftProduct = 1;
            }
            if (nums[n-1-i] != 0) {
                rightProduct = (rightProduct * nums[n - 1 - i]);
                maxProduct = Math.max(maxProduct, rightProduct);
            }
            else {
                maxProduct = Math.max(maxProduct, 0);
                rightProduct = 1;
            }
        }
        return maxProduct;
    }
}
