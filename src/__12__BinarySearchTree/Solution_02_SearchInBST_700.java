package __12__BinarySearchTree;

public class Solution_02_SearchInBST_700 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }
    // Time complexity O(log(n)) - Average case
    // Time complexity O(n) - Worst case
    // Space complexity O(1)
    // https://chatgpt.com/share/6a48c8f8-68ac-83e8-946d-d4ccc6c9dcca
    // Iterative approach
    public TreeNode searchBSTIterative(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            else if (root.val < val) {
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
        return null;
    }

    // Time complexity O(log(n)) - Average case
    // Time complexity O(n) - Worst case
    // Space complexity O(log(n)) - Average case (Recursion stack)
    // Space complexity O(n) - Worst case (Recursion stack)
    // Recursive approach
    public TreeNode searchBSTRecursive(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val < val) {
            return searchBSTRecursive(root.right, val);
        }
        else {
            return searchBSTRecursive(root.left, val);
        }
    }
}
