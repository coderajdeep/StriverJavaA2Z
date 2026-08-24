package __11__BinaryTree;

public class Solution_38_FlattenBinaryTreeToLinkedList_114 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode[] prev = {null};
        flattenUtils(root, prev);
    }
    private void flattenUtils(TreeNode root, TreeNode[] prev) {
        if (root == null) {
            return;
        }
        flattenUtils(root.right, prev);
        flattenUtils(root.left, prev);
        root.right = prev[0];
        root.left = null;
        prev[0] = root;
    }
}
