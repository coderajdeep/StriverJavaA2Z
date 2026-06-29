package Array;

public class Solution_25_SetMatrixZero_73 {
    // Time complexity O(n*m)
    // Space complexity O(n+m)
    public void setZeroes(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        // Default value is false
        boolean[] rows = new boolean[rowSize];
        boolean[] cols = new boolean[colSize];
        for (int i=0; i<rowSize; i++) {
            for (int j=0; j<colSize; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for (int i=0; i<rowSize; i++) {
            for (int j=0; j<colSize; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Time complexity O(n*m)
    // Space complexity O(1)
    public void setZeroesConstantSpace(int[][] matrix) {
        int rowSize = matrix.length, colSize = matrix[0].length, firstCol = -1;
        for (int i=0; i<rowSize; i++) {
            for (int j=0; j<colSize; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        firstCol = 0;
                    }
                    else {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        // We need to traverse right to left for each row and bottom to top for each column
        // Otherwise we will update the first row and column
        // If we want to do normal traversal then we need to leave the first row and column,
        // later we can do the traversal for them
        for (int i=rowSize-1; i>=0; i--) {
            for (int j=colSize-1; j>=0; j--) {
                if (i == 0) {
                    if (firstCol == 0) {
                        matrix[0][j] = 0;
                    }
                }
                else {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
