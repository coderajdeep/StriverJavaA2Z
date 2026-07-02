package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution_05_Inorder_94 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }

    // Time complexity O(n)
    // Space complexity O(n)
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<> ();
        List<Integer> result = new ArrayList<> ();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }

    // Time complexity O(n)
    // Space complexity O(n)
    // Recursive approach
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<> ();
        inOrder(root, result);
        return result;
    }
    private static void inOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
    }
}
