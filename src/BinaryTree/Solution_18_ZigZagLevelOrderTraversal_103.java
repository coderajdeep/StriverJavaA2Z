package BinaryTree;

import java.util.*;

public class Solution_18_ZigZagLevelOrderTraversal_103 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }
    // Time complexity O(n)
    // Space complexity O(n)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<List<Integer>> result = new ArrayList<> ();
        boolean isReversed = false;
        while (!queue.isEmpty()) {
            List<Integer> levelValues = new ArrayList<> ();
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                levelValues.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (isReversed) {
                Collections.reverse(levelValues);
            }
            isReversed = !isReversed;
            result.add(levelValues);
        }
        return result;
    }
}
