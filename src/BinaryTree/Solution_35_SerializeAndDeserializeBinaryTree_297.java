package BinaryTree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_35_SerializeAndDeserializeBinaryTree_297 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
            else {
                sb.append("N,");
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] values = data.split(",");
        if (values.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(values[index++]));
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            String left = values[index++];
            String right = values[index++];
            if (left.equals("N")) {
                curr.left = null;
            }
            else {
                TreeNode leftNode = new TreeNode(Integer.parseInt(left));
                curr.left = leftNode;
                queue.offer(leftNode);
            }
            if (right.equals("N")) {
                curr.right = null;
            }
            else {
                TreeNode rightNode = new TreeNode(Integer.parseInt(right));
                curr.right = rightNode;
                queue.offer(rightNode);
            }
        }
        return root;
    }
}
