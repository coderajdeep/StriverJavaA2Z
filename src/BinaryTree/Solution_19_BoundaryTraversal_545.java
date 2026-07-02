package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_19_BoundaryTraversal_545 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }

    // Time complexity O(n)
    // Space complexity O(n)
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<> ();
        if (root == null) {
            return result;
        }
        if (!isLeaf(root)) {
            result.add(root.val);
        }
        leftBoundary(root.left, result);
        leafBoundary(root, result);
        rightBoundary(root.right, result);
        return result;
    }
    private boolean isLeaf(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }
    private void leftBoundary(TreeNode root, List<Integer> result) {
        while (root != null && !isLeaf(root)) {
            result.add(root.val);
            if (root.left != null) {
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
    }
    private void rightBoundary(TreeNode root, List<Integer> result) {
        List<Integer> temp = new ArrayList<>();
        while (root != null && !isLeaf(root)) {
            temp.add(root.val);
            if (root.right != null) {
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
        Collections.reverse(temp);
        result.addAll(temp);
    }
    private void leafBoundary(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (isLeaf(root)) {
            result.add(root.val);
        }
        leafBoundary(root.left, result);
        leafBoundary(root.right, result);
    }
}
