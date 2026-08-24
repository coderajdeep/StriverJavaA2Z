package __11__BinaryTree;

import java.util.*;

public class Solution_20_VerticalOrderTraversal_987 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; this.left = null; this.right = null; }
    }

    // https://chatgpt.com/share/6a44baa7-b340-83ee-8b85-6411f52a4ea0
    // Time complexity O(nlogn)
    // Space complexity O(n)
    private static class Node {
        int x;
        int y;
        TreeNode node;
        Node(int x, int y, TreeNode node) {
            this.x = x;
            this.y = y;
            this.node = node;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, root));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int row = node.x;
            int col = node.y;
            TreeNode treeNode = node.node;
            map
                    .computeIfAbsent(col, k -> new TreeMap<> ())
                    .computeIfAbsent(row, k -> new ArrayList<> ())
                    .add(treeNode.val);
            if (treeNode.left != null) {
                queue.offer(new Node(row+1, col-1, treeNode.left));
            }
            if (treeNode.right != null) {
                queue.offer(new Node(row+1, col+1, treeNode.right));
            }
        }
        List<List<Integer>> result = new ArrayList<> ();
        for (Map<Integer, List<Integer>> innerMap : map.values()) {
            List<Integer> temp = new ArrayList<> ();
            for (List<Integer> list : innerMap.values()) {
                Collections.sort(list);
                temp.addAll(list);
            }
            result.add(temp);
        }
        return result;
    }

    static class Solution_20_VerticalOrderTraversal_tuf {
        private record Node(TreeNode root, int level, int position) {}
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<> (List.of());
            }
            Map<Integer, Map<Node, Integer>> map = new TreeMap<> ((a, b) -> Integer.compare(a, b));
            ArrayDeque<Node> queue = new ArrayDeque<> ();
            queue.offer(new Node(root, 0, 0));

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                map.computeIfAbsent(node.position(), k -> new TreeMap<> (
                        (a, b) -> {
                            if (a.level() == b.level()) {
                                return Integer.compare(a.root().val, b.root().val);
                            }
                            else {
                                return Integer.compare(a.level(), b.level());
                            }
                        }
                )).merge(node, 1, Integer::sum);
                if (node.root().left != null) {
                    queue.offer(new Node(node.root().left, node.level() + 1, node.position() - 1));
                }
                if (node.root().right != null) {
                    queue.offer(new Node(node.root().right, node.level() + 1, node.position() + 1));
                }
            }

            List<List<Integer>> result = new ArrayList<> ();
            for (Map.Entry<Integer, Map<Node, Integer>> entry : map.entrySet()) {
                List<Integer> list = new ArrayList<> ();
                Map<Node, Integer> mapValue = entry.getValue();
                for (Map.Entry<Node, Integer> mapEntry : mapValue.entrySet()) {
                    int value = mapEntry.getValue();
                    for (int i=0; i<value; i++) {
                        list.add(mapEntry.getKey().root().val);
                    }
                }
                result.add(list);
            }
            return result;
        }
    }
}
