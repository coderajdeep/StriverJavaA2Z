package Tries;

import java.util.List;

public class Solution_03_LongestWordWithAllPrefix_720_1858 {
    private class Trie {
        final Trie[] links;
        boolean isEnd;
        Trie() {
            links = new Trie[26];
            isEnd = false;
        }
    }
    public String completeString(List<String> words) {
        Trie root = new Trie();
        // time complexity O(n*l)
        for (String word : words) {
            insert(word, root);
        }
        String result = "";
        // Time complexity O(n*l)
        for (String word : words) {
            if (checkAllPrefixOfString(word, root)) {
                if (word.length() > result.length()) {
                    result = word;
                }
                // In this senario, worst case time complexity O(l)
                else if (word.length() == result.length() && (word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }
        return result != "" ? result : "None";
    }
    // Time complexity O(l)
    // l is the the length of String
    private void insert(String str, Trie root) {
        for (char ch : str.toCharArray()) {
            int index = ch - 'a';
            if (root.links[index] == null) {
                root.links[index] = new Trie();
            }
            root = root.links[index];
        }
        root.isEnd = true;
    }
    // Time complexity O(l)
    // l is the the length of String
    private boolean checkAllPrefixOfString(String str, Trie root) {
        for (char ch : str.toCharArray()) {
            int index = ch - 'a';
            if (root.links[index] == null) {
                return false;
            }
            root = root.links[index];
            if (root.isEnd == false) {
                return false;
            }
        }
        return true;
    }
}
