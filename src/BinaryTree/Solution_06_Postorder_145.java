package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_06_Postorder_145 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }

    // Time complexity O(n)
    // Space complexity O(n)
    // Iterative approach
    // Two stack approach
    public List<Integer> postorderTraversalIterative(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<> ();
        stack.push(root);
        List<Integer> result = new ArrayList<> ();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrderUtils(root, result);
        return result;
    }
    private static void postOrderUtils(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postOrderUtils(root.left, result);
        postOrderUtils(root.right, result);
        result.add(root.val);
    }
}
