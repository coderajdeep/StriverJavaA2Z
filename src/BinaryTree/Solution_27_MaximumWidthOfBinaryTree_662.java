package BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_27_MaximumWidthOfBinaryTree_662 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }
    private static class Node {
        TreeNode root;
        long index;
        Node(TreeNode root, long index) {
            this.root = root;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(root, 0L));
        int width = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            long firstNodeIndex = -1, lastNodeIndex = -1;
            for (int i=0; i<size; i++) {
                Node node = queue.poll();
                TreeNode treeNode = node.root;
                long index = node.index;
                if (i == 0) {
                    firstNodeIndex = index;
                }
                index -= firstNodeIndex;
                if (i == size - 1) {
                    lastNodeIndex = index;
                }
                if (treeNode.left != null) {
                    queue.offer(new Node(treeNode.left, leftChild(index)));
                }
                if (treeNode.right != null) {
                    queue.offer(new Node(treeNode.right, rightChild(index)));
                }
            }
            width = Math.max(width, (int)(lastNodeIndex + 1));
        }
        return width;
    }

    private long leftChild(long index) {
        return 2 * index + 1;
    }
    private long rightChild(long index) {
        return 2 * index + 2;
    }
}
