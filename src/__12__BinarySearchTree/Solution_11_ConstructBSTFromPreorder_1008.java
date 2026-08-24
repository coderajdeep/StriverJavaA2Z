package __12__BinarySearchTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_11_ConstructBSTFromPreorder_1008 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }

    // Best approach
    // Time complexity O(n)
    // Space complexity O(h)
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(new int[] {0}, preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private TreeNode buildTree(int[] preIndex, int[] preorder, int min, int max) {
        if (preIndex[0] == preorder.length) {
            return null;
        }
        int val = preorder[preIndex[0]];
        if (val < min || val > max) {
            return null;
        }
        TreeNode root = new TreeNode(val);
        preIndex[0]++;
        root.left = buildTree(preIndex, preorder, min, val);
        root.right = buildTree(preIndex, preorder, val, max);
        return root;
    }

    // Time complexity O(n*log(n))
    // Space complexity O(n)
    public TreeNode bstFromPreorderNlogNApproach(int[] preorder) {
        int size = preorder.length;
        int[] inorder = new int[size];
        System.arraycopy(preorder, 0, inorder, 0, size);
        Arrays.sort(inorder);
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i=0; i<size; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeNlogNApproach(0, size-1, new int[] {0}, preorder, inorderMap);
    }
    private TreeNode buildTreeNlogNApproach(int inStart, int inEnd, int[] preIndex, int[] preorder, Map<Integer, Integer> inorder) {
        if (inStart > inEnd) {
            return null;
        }
        int value = preorder[preIndex[0]];
        preIndex[0]++;
        int rootIndex = inorder.get(value);
        TreeNode root = new TreeNode(value);
        root.left = buildTreeNlogNApproach(inStart, rootIndex-1, preIndex, preorder, inorder);
        root.right = buildTreeNlogNApproach(rootIndex+1, inEnd, preIndex, preorder, inorder);
        return root;
    }
}
