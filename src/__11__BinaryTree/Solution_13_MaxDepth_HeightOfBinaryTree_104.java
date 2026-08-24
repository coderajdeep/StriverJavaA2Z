package __11__BinaryTree;

public class Solution_13_MaxDepth_HeightOfBinaryTree_104 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }
    // Time complexity O(n)
    // Space complexity O(n)
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
