package __07__StackQueue;

public class Solution_19_TrappingRainWater_42 {
    // Time complexity O(n)
    // Space complexity O(n)
    public int trap(int[] height) {
        int size = height.length;
        if (size < 3) return 0;
        int[] right = new int[size];
        for (int i=size-2; i>= 1; i--) {
            right[i] = Math.max(right[i+1], height[i+1]);
        }
        int result = 0, leftMax = height[0];
        for (int i=1; i<= size-2; i++) {
            leftMax = Math.max(leftMax, height[i-1]);
            int minHeight = Math.min(leftMax, right[i]);
            if (height[i] < minHeight) {
                result += (minHeight - height[i]);
            }
        }
        return result;
    }
}
