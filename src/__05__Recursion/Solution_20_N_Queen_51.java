package __05__Recursion;

import java.util.ArrayList;
import java.util.List;

public class Solution_20_N_Queen_51 {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        solve(0, board, result);
        return result;
    }
    private static void solve(int rowPos, char[][] board, List<List<String>> result) {
        if (rowPos == board.length) {
            List<String> list = new ArrayList<> ();
            for (int i=0; i<rowPos; i++) {
                list.add(new String(board[i]));
            }
            result.add(list);
            return;
        }
        for (int i=0; i<board[0].length; i++) {
            if (isPositionValid(rowPos, i, board)) {
                board[rowPos][i] = 'Q';
                solve(rowPos + 1, board, result);
                board[rowPos][i] = '.';
            }
        }
    }
    private static boolean isPositionValid(int x, int y, char[][] board) {
        // upper column check
        for (int i=x-1; i>=0; i--) {
            if (board[i][y] != '.') {
                return false;
            }
        }
        //left diagonal check
        int i = x-1, j = y-1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] != '.') {
                return false;
            }
            i--;
            j--;
        }
        // right diagonal check
        i = x-1;
        j = y+1;
        while (i >= 0 && j < board[0].length) {
            if (board[i][j] != '.') {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
