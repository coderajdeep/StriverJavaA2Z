package Graph;

import java.util.*;

public class Solution_16_WordLadderI_127 {
    // https://chatgpt.com/share/6a29959a-b8a8-8324-add8-7262caa21365
    // Why same word will not come again?
    // https://youtu.be/tRPda0rcf8E?t=864
    private record Pair(String str, int dist) {}
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        int m = beginWord.length();
        char[] str = new char[m];
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(beginWord, 1));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int i=0; i<m; i++) {
                str[i] = pair.str().charAt(i);
            }
            for (int i=0; i<m; i++) {
                char ch = str[i];
                for (char c='a'; c<='z'; c++) {
                    str[i] = c;
                    String st = String.valueOf(str);
                    if (st.equals(endWord)) {
                        return pair.dist() + 1;
                    }
                    if (set.contains(st)) {
                        queue.offer(new Pair(st, pair.dist() + 1));
                        set.remove(st);
                    }
                }
                str[i] = ch;
            }
        }
        return 0;
    }
}
