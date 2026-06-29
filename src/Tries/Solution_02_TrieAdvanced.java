package Tries;

// https://chatgpt.com/share/6a2e7217-bda8-83ee-ac66-000a22ba718a

public class Solution_02_TrieAdvanced {

    static class Trie {

        private final Trie[] values;
        private int prefixCount;
        private int endCount;

        public Trie() {
            values = new Trie[26];
            prefixCount = 0;
            endCount = 0;
        }

        public void insert(String word) {
            Trie root = this;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (root.values[index] == null) {
                    root.values[index] = new Trie();
                }
                root = root.values[index];
                root.prefixCount++;
            }
            root.endCount++;
        }

        public int countWordsEqualTo(String word) {
            Trie root = this;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (root.values[index] == null) {
                    return 0;
                }
                root = root.values[index];
            }
            return root.endCount;
        }

        public int countWordsStartingWith(String prefix) {
            Trie root = this;
            for (char ch : prefix.toCharArray()) {
                int index = ch - 'a';
                if (root.values[index] == null) {
                    return 0;
                }
                root = root.values[index];
            }
            return root.prefixCount;
        }

        public void erase(String word) {
            if (countWordsEqualTo(word) == 0) {
                return;
            }
            Trie root = this;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (root.values[index] == null) {
                    return;
                }
                root = root.values[index];
                root.prefixCount--;
            }
            root.endCount--;
        }
    }
}
