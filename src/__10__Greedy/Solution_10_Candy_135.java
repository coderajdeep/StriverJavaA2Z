package __10__Greedy;

public class Solution_10_Candy_135 {
    public int candyBestSolution(int[] ratings) {
        int n = ratings.length, i = 1, top = 1, down = 1, total = 1;
        while (i < n) {
            while (i < n && ratings[i-1] == ratings[i]) {
                total += 1;
                i++;
                continue;
            }
            top = 1;
            while (i < n && ratings[i-1] < ratings[i]) {
                top++;
                total += top;
                i++;
            }
            down = 1;
            while (i < n && ratings[i-1] > ratings[i]) {
                total += down;
                down++;
                i++;
            }
            if (down > top) {
                total += (down - top);
            }
        }
        return total;
    }
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        for (int i=1; i<n; i++) {
            if (ratings[i-1] < ratings[i]) {
                left[i] = left[i-1] + 1;
            }
            else {
                left[i] = 1;
            }
        }
        right[n-1] = 1;
        for (int i=n-2; i>=0; i--) {
            if (ratings[i+1] < ratings[i]) {
                right[i] = right[i+1] + 1;
            }
            else {
                right[i] = 1;
            }
        }
        int total = 0;
        for (int i=0; i<n; i++) {
            total += Math.max(left[i], right[i]);
        }
        return total;
    }
}
