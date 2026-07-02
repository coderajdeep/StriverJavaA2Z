package BinaryTree;

import java.util.*;

public class Solution_30_MinTimeToBurnTheBinaryTree_2385 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }
    // Time complexity O(n)
    // Space complexity O(n)
    public int amountOfTime(TreeNode root, int start) {
        if (root == null) {
            return 0;
        }
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        TreeNode[] startCopy = {null};
        dfs(root, startCopy, start, parents);
        TreeNode startNode = startCopy[0];
        if (startNode == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        int time = 0;
        queue.offer(startNode);
        visited.add(startNode);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    queue.offer(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    queue.offer(node.right);
                    visited.add(node.right);
                }
                TreeNode parent = parents.get(node);
                if (parent != null && !visited.contains(parent)) {
                    queue.offer(parent);
                    visited.add(parent);
                }
            }
            time++;
        }
        return time - 1;
    }
    private void dfs(TreeNode root, TreeNode[] startNode, int start, Map<TreeNode, TreeNode> parents) {
        if (root == null) {
            return;
        }
        if (root.val == start) {
            startNode[0] = root;
        }
        if (root.left != null) {
            parents.put(root.left, root);
            dfs(root.left, startNode, start, parents);
        }
        if (root.right != null) {
            parents.put(root.right, root);
            dfs(root.right, startNode, start, parents);
        }
    }
}
