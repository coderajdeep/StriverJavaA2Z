package BinarySearchTree;

public class Solution_Q1_ConstructBSTFromPostorder {
    public static class Node {
        int val;
        Node left;
        Node right;
        Node(int val) { this.val = val; this.left = null; this.right = null; }
    }
    Node constructTree(int[] post) {
        int[] index = {post.length - 1};
        return build(post, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private Node build(int[] post, int[] index, int min, int max) {
        if (index[0] < 0) {
            return null;
        }
        int val = post[index[0]];
        if (val < min || val > max) {
            return null;
        }
        Node root = new Node(val);
        index[0]--;

        root.right = build(post, index, val, max);
        root.left = build(post, index, min, val);
        return root;
    }
}
