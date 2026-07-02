package BinaryTree;

public class Solution_31_CountCompleteBinaryTreeNodes_222 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }
    // Time and space complexity
    // https://chatgpt.com/share/6a460c1e-7c50-83e8-8889-ca4ef4db862c
    // Time complexity O((log(n))^2)
    // Space complexity O(log(n))
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        if (leftHeight == rightHeight) {
            return ((1 << leftHeight) - 1);
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    private int getLeftHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }
    private int getRightHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.right;
        }
        return height;
    }
}
