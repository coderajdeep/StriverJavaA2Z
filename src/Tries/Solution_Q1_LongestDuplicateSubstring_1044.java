package Tries;

public class Solution_Q1_LongestDuplicateSubstring_1044 {

    // This solution is not optimized
    private static class Trie {
        private final Trie[] links;
        private int count;
        Trie() {
            links = new Trie[26];
            count = 0;
        }
    }
    public String longestDupSubstring(String s) {
        int n = s.length(), maxLength = 0, start = -1, end = -1;
        Trie root = new Trie();
        for (int i=0; i<n; i++) {
            Trie curr = root;
            for (int j=i; j<n; j++) {
                int index = s.charAt(j) - 'a';
                if (curr.links[index] == null) {
                    curr.links[index] = new Trie();
                }
                curr = curr.links[index];
                curr.count++;
                if (curr.count > 1) {
                    if (j-i+1 > maxLength) {
                        maxLength = j-i+1;
                        start = i;
                        end = j;
                    }
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }
        return maxLength == 0 ? "" : s.substring(start, end+1);
    }
}
