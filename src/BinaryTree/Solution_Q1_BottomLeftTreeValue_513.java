package BinaryTree;

public class Solution_Q1_BottomLeftTreeValue_513 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }
    // Time complexity O(n)
    // Space complexity O(n)
    public int findBottomLeftValue(TreeNode root) {
        int[] pair = {1, root.val};
        // (level, value)
        // value will be overwritten in each level
        // at the end, the last level value will be there inside answer
        helper(root, pair, 1);
        return pair[1];
    }
    private void helper(TreeNode root, int[] pair, int level) {
        if (root == null) {
            return;
        }
        if (pair[0] < level) {
            pair[0] = level;
            pair[1] = root.val;
        }
        helper(root.left, pair, level+1);
        helper(root.right, pair, level+1);
    }
}
