package Recursion;

import java.util.HashSet;
import java.util.Set;

public class Solution_19_Word_Search_79 {
    // No extra space for hashing
    public boolean existBestSolution(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] == word.charAt(0) && isExist(i, j, board, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean isValidIndex(int i, int j, char[][] board) {
        return i >=0 && i < board.length && j >= 0 && j < board[0].length;
    }
    private static boolean isExist(int i, int j, char[][] board, int wordIndex, String word) {
        if (!isValidIndex(i, j, board) || board[i][j] == '-' || board[i][j] != word.charAt(wordIndex)) {
            return false;
        }
        if (wordIndex == word.length() - 1) {
            return true;
        }
        char ch = board[i][j];
        board[i][j] = '-';

        boolean result = (
                isExist(i-1, j, board, wordIndex + 1, word) ||
                        isExist(i, j + 1, board, wordIndex + 1, word) ||
                        isExist(i + 1, j, board, wordIndex + 1, word) ||
                        isExist(i, j - 1, board, wordIndex + 1, word)
        );
        board[i][j] = ch;
        return result;
    }

    // Using extra space
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                Set<String> hash = new HashSet<>();
                if (isExist(i, j, 0, board, word, hash)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean isExist(int i, int j, int wordIndex, char[][] board, String word, Set<String> hash) {
        if (!isIndexValid(i, j, board) || board[i][j] != word.charAt(wordIndex) || hash.contains(Integer.toString(i) + "-" + Integer.toString(j))) {
            return false;
        }
        if (wordIndex + 1 == word.length()) {
            return true;
        }
        hash.add(Integer.toString(i) + "-" + Integer.toString(j));
        boolean result = ( isExist(i, j - 1, wordIndex + 1, board, word, hash) ||
                isExist(i - 1, j, wordIndex + 1, board, word, hash) ||
                isExist(i, j + 1, wordIndex + 1, board, word, hash) ||
                isExist(i + 1, j, wordIndex + 1, board, word, hash));
        hash.remove(Integer.toString(i) + "-" + Integer.toString(j));
        return result;
    }
    private static boolean isIndexValid(int i, int j, char[][] board) {
        return (i>=0 && i<board.length && j>=0 && j<board[0].length);
    }
}
