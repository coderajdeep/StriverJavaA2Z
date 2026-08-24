package __11__BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution_04_Preorder_144 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }

    // Time complexity O(n)
    // Space complexity O(n)
    // Iterative approach
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<> ();
        stack.push(root);
        List<Integer> result = new ArrayList<> ();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    // Time complexity O(n)
    // Space complexity O(n)
    // Recursive approach
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<> ();
        preorderUtils(root, preorder);
        return preorder;
    }
    private void preorderUtils(TreeNode root, List<Integer> preorder) {
        if (root == null) {
            return;
        }
        preorder.add(root.val);
        preorderUtils(root.left, preorder);
        preorderUtils(root.right, preorder);
    }
}
