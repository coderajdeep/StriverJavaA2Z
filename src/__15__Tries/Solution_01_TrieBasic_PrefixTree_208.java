package __15__Tries;

public class Solution_01_TrieBasic_PrefixTree_208 {
    static class TrieWithoutSeparateNode {

        private final TrieWithoutSeparateNode[] values;
        private boolean isEnd;

        public TrieWithoutSeparateNode() {
            values = new TrieWithoutSeparateNode[26];
            isEnd = false;
        }

        public void insert(String word) {
            TrieWithoutSeparateNode root = this;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (root.values[index] == null) {
                    root.values[index] = new TrieWithoutSeparateNode();
                }
                root = root.values[index];
            }
            root.isEnd = true;
        }

        public boolean search(String word) {
            TrieWithoutSeparateNode root = this;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (root.values[index] == null) {
                    return false;
                }
                root = root.values[index];
            }
            return root.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieWithoutSeparateNode root = this;
            for (char ch : prefix.toCharArray()) {
                int index = ch - 'a';
                if (root.values[index] == null) {
                    return false;
                }
                root = root.values[index];
            }
            return true;
        }
    }

    static class Trie {

        private static class Node {
            Node[] values;
            boolean isEnd;
            Node() {
                values = new Node[26];
                isEnd = false;
            }
        }

        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node curr = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (curr.values[index] == null) {
                    curr.values[index] = new Node();
                }
                curr = curr.values[index];
            }
            curr.isEnd = true;
        }

        public boolean search(String word) {
            Node curr = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (curr.values[index] == null) {
                    return false;
                }
                curr = curr.values[index];
            }
            return curr.isEnd;
        }

        public boolean startsWith(String prefix) {
            Node curr = root;
            for (char ch : prefix.toCharArray()) {
                int index = ch - 'a';
                if (curr.values[index] == null) {
                    return false;
                }
                curr = curr.values[index];
            }
            return true;
        }
    }
}
