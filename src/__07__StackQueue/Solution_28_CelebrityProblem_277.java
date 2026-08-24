package __07__StackQueue;

public class Solution_28_CelebrityProblem_277 {
    private int[][] matrix;
    private final int n;
    public Solution_28_CelebrityProblem_277(int n, int[][] matrix) {
        this.n = n;
        if (matrix.length == n) {
            this.matrix = new int[n][n];
            for (int i=0; i<n; i++) {
                System.arraycopy(matrix[i], 0, this.matrix[i], 0, n);
            }
        }
    }
    private boolean knows(int a, int b) {
        /* The knows API is defined in the parent class Relation.
        boolean knows(int a, int b); */
        if (a < 0 || a >= n || b < 0 || b >= n) {
            return false;
        }
        return matrix[a][b] == 1;
    }

    // Best solution
    public int findCelebrity(int n) {
        int top = 0, down = n-1;
        while (top < down) {
            if (knows(top, down)) {
                top++;
            }
            else if (knows(down, top)) {
                down--;
            }
            else {
                top++;
                down--;
            }
        }
        if (top > down) {
            return -1;
        }
        for (int i=0; i<n; i++) {
            if (i != top) {
                if (!knows(i, top) || knows(top, i)) {
                    return -1;
                }
            }
        }
        return top;
    }

    public int findCelebrityLeetcodeSolution(int n) {
        for (int i=0; i<n; i++) {
            if (isCelebrity(i, n)) {
                return i;
            }
        }
        return -1;
    }
    private boolean isCelebrity(int a, int n) {
        for (int b=0; b<n; b++) {
            if (a == b) continue;
            if (knows(a, b) || !knows(b, a)) {
                return false;
            }
        }
        return true;
    }

    public int findCelebrityStriverSolution(int n) {
        int[] i_know = new int[n];
        int[] know_me = new int[n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i != j) {
                    if (knows(i, j)) {
                        i_know[i]++;
                        know_me[j]++;
                    }
                }

            }
        }
        for (int i=0; i<n; i++) {
            if (i_know[i] == 0 && know_me[i] == (n-1)) {
                return i;
            }
        }
        return -1;
    }
}
