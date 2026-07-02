package BinaryTree;

public class Solution_15_DiameterOfBinaryTree_543 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }
    // Time complexity O(n)
    // Space complexity O(n)
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }
    private int height(TreeNode root, int[] diameter) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left, diameter);
        int rightHeight = height(root.right, diameter);
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
