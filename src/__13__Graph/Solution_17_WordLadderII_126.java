package __13__Graph;

import java.util.*;

public class Solution_17_WordLadderII_126 {
    public List<List<String>> findSequences(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<> ();
        if (beginWord.equals(endWord)) {
            result.add(new ArrayList<String>(List.of(endWord)));
            return result;
        }
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return result;
        }
        int m = beginWord.length();
        char[] str = new char[m];
        Queue<List<String>> queue = new ArrayDeque<>();
        queue.offer(new ArrayList<> (List.of(beginWord)));
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;
            List<String> deletedWords = new ArrayList<> ();
            for (int in=0; in<size; in++) {
                List<String> list = queue.poll();
                String lastStr = list.get(list.size() - 1);
                for (int i=0; i<m; i++) {
                    str[i] = lastStr.charAt(i);
                }
                for (int i=0; i<m; i++) {
                    char ch = str[i];
                    for (char c='a'; c<='z'; c++) {
                        if (c == ch) {
                            continue;
                        }
                        str[i] = c;
                        String st = String.valueOf(str);
                        if (st.equals(endWord)) {
                            list.add(endWord);
                            result.add(new ArrayList<String> (list));
                            flag = true;
                        }
                        if (set.contains(st)) {
                            list.add(st);
                            deletedWords.add(st);
                            queue.offer(new ArrayList<String> (list));
                            list.remove(list.size() - 1);
                        }
                    }
                    str[i] = ch;
                }
            }
            if (flag) {
                return result;
            }
            for (String s : deletedWords) {
                set.remove(s);
            }
        }
        return new ArrayList<List<String>> ();
    }
}
