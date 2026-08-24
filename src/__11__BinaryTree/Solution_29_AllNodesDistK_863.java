package __11__BinaryTree;

import java.util.*;

public class Solution_29_AllNodesDistK_863 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }

    // Time complexity O(n)
    // Space complexity O(n)
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<> ();
        if (root == null) {
            return result;
        }
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        dfs(root, parents);
        Queue<TreeNode> queue = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        int level = 0;
        queue.offer(target);
        visited.add(target);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (level == k) {
                    result.add(node.val);
                }
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
            if (level == k) {
                break;
            }
            level++;
        }
        return result;
    }
    private void dfs(TreeNode root, Map<TreeNode, TreeNode> parents) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parents.put(root.left, root);
            dfs(root.left, parents);
        }
        if (root.right != null) {
            parents.put(root.right, root);
            dfs(root.right, parents);
        }
    }
}
