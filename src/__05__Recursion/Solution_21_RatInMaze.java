package __05__Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_21_RatInMaze {
    public List<String> findPath(int[][] grid) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        findPathUtils(0, 0, grid, 'X', path, result);
        Collections.sort(result);
        return result;
    }
    private static void findPathUtils(int i, int j, int[][] grid, char direction, StringBuilder path, List<String> result) {

        if (!isCellValid(i, j, grid) || grid[i][j] == -1 || grid[i][j] == 0) {
            return;
        }

        boolean added = false;
        if (direction != 'X') {
            path.append(direction);
            added = true;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            result.add(path.toString());
            if (added) path.setLength(path.length() - 1);
            return;
        }

        grid[i][j] = -1;

        findPathUtils(i - 1, j, grid, 'U', path, result);
        findPathUtils(i, j + 1, grid, 'R', path, result);
        findPathUtils(i + 1, j, grid, 'D', path, result);
        findPathUtils(i, j - 1, grid, 'L', path, result);

        grid[i][j] = 1;

        if (added) {
            path.setLength(path.length() - 1);
        }
    }
    private static boolean isCellValid(int i, int j, int[][] grid) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
