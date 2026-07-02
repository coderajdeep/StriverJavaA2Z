package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class Solution_34_ConstructBinaryTreeFromInorderPostorder_106 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }
    // Time complexity O(n)
    // Space complexity O(n)
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer, Integer> inOrderHash = new HashMap<>();
        for (int i=0; i<n; i++) {
            inOrderHash.put(inorder[i], i);
        }
        int[] postIndex = {n-1};
        return build(0, n-1, postIndex, postorder, inOrderHash);
    }
    private TreeNode build(int inStart, int inEnd, int[] postIndex, int[] postorder, Map<Integer, Integer> inOrderHash) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex[0]]);
        int inRootIndex = inOrderHash.get(postorder[postIndex[0]]);
        postIndex[0]--;
        root.right = build(inRootIndex+1, inEnd, postIndex, postorder, inOrderHash);
        root.left = build(inStart, inRootIndex-1, postIndex, postorder, inOrderHash);
        return root;
    }
}
