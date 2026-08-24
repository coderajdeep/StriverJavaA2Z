package __11__BinaryTree;

import java.util.*;

public class Solution_22_BottomViewOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }
    static class Node {
        TreeNode root;
        int vLevel;
        Node(TreeNode root, int vLevel) {
            this.root = root;
            this.vLevel = vLevel;
        }
    }
    public List<Integer> bottomView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(root, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            map.put(node.vLevel, node.root.val);
            if (node.root.left != null) {
                queue.offer(new Node(node.root.left, node.vLevel - 1));
            }
            if (node.root.right != null) {
                queue.offer(new Node(node.root.right, node.vLevel + 1));
            }
        }
        return new ArrayList<> (map.values());
    }
}
