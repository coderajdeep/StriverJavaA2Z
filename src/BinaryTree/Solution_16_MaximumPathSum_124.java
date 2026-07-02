package BinaryTree;

public class Solution_16_MaximumPathSum_124 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] maxPathSum = {Integer.MIN_VALUE};
        maxPathSumUtils(root, maxPathSum);
        return maxPathSum[0];
    }
    private int maxPathSumUtils(TreeNode root, int[] maxPathSum) {
        if (root == null) {
            return 0;
        }
        int sum = root.val;
        int leftPathSum = Math.max(maxPathSumUtils(root.left, maxPathSum), 0);
        sum += leftPathSum;
        int rightPathSum = Math.max(maxPathSumUtils(root.right, maxPathSum), 0);
        sum += rightPathSum;
        maxPathSum[0] = Math.max(maxPathSum[0], sum);
        return root.val + Math.max(leftPathSum, rightPathSum);
    }
}
