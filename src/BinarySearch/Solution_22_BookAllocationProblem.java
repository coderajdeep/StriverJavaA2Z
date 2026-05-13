package BinarySearch;

public class Solution_22_BookAllocationProblem {
    // TakeUForward Plus explanation is very good
    // Time complexity O(nlog(n))
    // Space complexity O(1)
    public int findPages(int[] nums, int m) {
        int n = nums.length;
        if (n < m) {
            return -1;
        }
        int low = Integer.MIN_VALUE, high = 0, mid, ans = -1;
        for (int i=0; i<n; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }
        while (low <= high) {
            mid = low + (high - low) / 2;
            int count = getStudentCount(nums, mid);
            if (count <= m) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private int getStudentCount(int[] nums, int pages) {
        int students = 0, pageCount = 0;
        for (int num : nums) {
            pageCount += num;
            if (pageCount > pages) {
                students++;
                pageCount = num;
            }
        }
        // Here pageCount > 0 && pageCount <= pages
        return (students + 1);
    }
}
