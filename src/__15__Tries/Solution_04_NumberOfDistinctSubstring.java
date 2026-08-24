package __15__Tries;

public class Solution_04_NumberOfDistinctSubstring {
    private static class Trie {
        private final Trie[] links;
        Trie() {
            links = new Trie[26];
        }
    }
    public int countDistinctSubstring(String s) {
        int n = s.length(), count = 0;
        Trie root = new Trie();
        for (int i=0; i<n; i++) {
            Trie curr = root;
            for (int j=i; j<n; j++) {
                int index = s.charAt(j) - 'a';
                if (curr.links[index] == null) {
                    curr.links[index] = new Trie();
                    count++;
                }
                curr = curr.links[index];
            }
        }
        // Need to consider empty substring as well
        return count + 1;
    }
}
