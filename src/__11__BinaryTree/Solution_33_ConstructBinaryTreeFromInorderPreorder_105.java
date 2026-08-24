package __11__BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class Solution_33_ConstructBinaryTreeFromInorderPreorder_105 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }
    // Time complexity O(n)
    // Space complexity O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        Map<Integer, Integer> inOrderHash = new HashMap<>();
        for (int i=0; i<n; i++) {
            inOrderHash.put(inorder[i], i);
        }
        int[] preIndex = {0};
        return build(0, n-1, preIndex, preorder, inOrderHash);
    }
    private TreeNode build(int inStart, int inEnd, int[] preIndex, int[] preorder, Map<Integer, Integer> hash) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex[0]]);
        int inRootIndex = hash.get(preorder[preIndex[0]]);
        preIndex[0]++;
        root.left = build(inStart, inRootIndex-1, preIndex, preorder, hash);
        root.right = build(inRootIndex+1, inEnd, preIndex, preorder, hash);
        return root;
    }
}
