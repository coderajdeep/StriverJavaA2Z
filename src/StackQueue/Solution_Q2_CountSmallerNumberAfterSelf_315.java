package StackQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_Q2_CountSmallerNumberAfterSelf_315 {
    private static class Pair {
        int value;
        int index;
        Pair(int val, int idx) {
            value = val;
            index = idx;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Pair[] array = new Pair[n];
        Pair[] temp = new Pair[n];
        for (int i=0; i<n; i++) {
            Pair pair = new Pair(nums[i], i);
            array[i] = temp[i] = pair;
        }
        List<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));
        mergeSort(0, n-1, array, temp, result);
        return result;
    }
    private void mergeSort(int start, int end, Pair[] array, Pair[] temp, List<Integer> result) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(start, mid, array, temp, result);
        mergeSort(mid+1, end, array, temp, result);
        merge(start, mid, end, array, temp, result);
    }
    private void merge(int start, int mid, int end, Pair[] array, Pair[] temp, List<Integer> result) {
        for (int i=start; i<=end; i++) {
            temp[i] = array[i];
        }
        int i = start, j = mid+1, k = start;
        while (i <= mid && j <= end) {
            if (temp[i].value > temp[j].value) {
                result.set(temp[i].index, result.get(temp[i].index) + (end - j + 1));
                array[k++] = temp[i++];
            }
            else {
                array[k++] = temp[j++];
            }
        }
        while (i <= mid) {
            array[k++] = temp[i++];
        }
        while (j <= end) {
            array[k++] = temp[j++];
        }
    }
}
