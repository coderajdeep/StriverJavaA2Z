package __12__BinarySearchTree;

public class Solution_03_MinInBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }
    // Time complexity O(log(n)) - Average case
    // Time complexity O(n) - Worst case
    // Space complexity O(1)
    public int minValue(TreeNode root) {
        int min = Integer.MAX_VALUE;
        while (root != null) {
            min = Math.min(min, root.val);
            root = root.left;
        }
        return min;
    }
}
