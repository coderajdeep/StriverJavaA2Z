package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Solution_25_AllRootToLeavePaths_257 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }

    // For time and space complexity
    // https://chatgpt.com/share/6a4507e9-c654-83e8-911c-f9ccfceb2336
    public List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<> ();
        List<Integer> path = new ArrayList<> ();
        binaryTreePathsUtils(root, path, result);
        List<String> resultString = new ArrayList<>();
        for (List<Integer> list : result) {
            StringBuilder sb = new StringBuilder();
            for (int element : list) {
                if (!sb.isEmpty()) {
                    sb.append("->");
                }
                sb.append(String.valueOf(element));
            }
            resultString.add(sb.toString());
        }
        return resultString;
    }
    private void binaryTreePathsUtils(TreeNode root, List<Integer> path, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<> (path));
        }
        binaryTreePathsUtils(root.left, path, result);
        binaryTreePathsUtils(root.right, path, result);
        path.remove(path.size() - 1);
    }
}
