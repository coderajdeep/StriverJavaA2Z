package __11__BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution_03_PreInPostOrderTraversal {
    // Time complexity O(n)
    // Space complexity O(n)
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { data = val; left = null; right = null; }
    }
    private static class Node {
        TreeNode treeNode;
        int number;
        Node(TreeNode treeNode, int number) {
            this.treeNode = treeNode;
            this.number = number;
        }
    }
    List<List<Integer>> treeTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<> ();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> preorder = new ArrayList<> ();
        List<Integer> inorder = new ArrayList<> ();
        List<Integer> postorder = new ArrayList<> ();
        ArrayDeque<Node> stack = new ArrayDeque<> ();
        stack.push(new Node(root, 1));
        while (!stack.isEmpty()) {
            Node treeNode = stack.pop();
            TreeNode node = treeNode.treeNode;
            int number = treeNode.number;
            if (number == 1) {
                preorder.add(node.data);
                stack.push(new Node(node, 2));
                if (node.left != null) {
                    stack.push(new Node(node.left, 1));
                }
            }
            else if (number == 2) {
                inorder.add(node.data);
                stack.push(new Node(node, 3));
                if (node.right != null) {
                    stack.push(new Node(node.right, 1));
                }
            }
            else {
                postorder.add(node.data);
            }
        }
        result.add(inorder);
        result.add(preorder);
        result.add(postorder);
        return result;
    }
}
