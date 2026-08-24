package __01__Array;

public class Solution_26_RotateMatrix_48 {
    // Time complexity O(n*m)
    // Space complexity O(1)
    // https://chatgpt.com/share/69d64945-f5b8-8321-8410-542195b3b78a
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // Transpose of a matrix
        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        for (int i=0; i<n; i++) {
            reverse(matrix, i);
        }
    }
    private void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }
    private void reverse(int[][] matrix, int row) {
        int start = 0, end = matrix.length - 1;
        while (start < end) {
            swap(matrix, row, start, row, end);
            start++;
            end--;
        }
    }
}
