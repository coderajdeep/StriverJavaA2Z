package __11__BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Solution_23_RightViewOfBinaryTree_199 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }
    // Time complexity O(n)
    // Space complexity O(n)
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightViewUtils(root, 1, result);
        return result;
    }
    private void rightViewUtils(TreeNode root, int currLevel, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (result.size() < currLevel) {
            result.add(root.val);
        }
        rightViewUtils(root.right, currLevel + 1, result);
        rightViewUtils(root.left, currLevel + 1, result);
    }
}
