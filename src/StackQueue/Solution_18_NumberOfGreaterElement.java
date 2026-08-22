package StackQueue;

import java.util.ArrayList;
import java.util.List;

public class Solution_18_NumberOfGreaterElement {
    private static class Pair {
        private int value;
        private int index;
        private Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    public List<Integer> count_NGE(int[] arr, int[] indices) {
        int size = arr.length;
        Pair[] array = new Pair[size];
        Pair[] temp = new Pair[size];
        int[] nge = new int[size];
        for (int i=0; i<size; ++i) {
            Pair pair = new Pair(arr[i], i);
            array[i] = pair;
            temp[i] = pair;
        }
        mergeSort(0, size - 1, array, temp, nge);
        List<Integer> result = new ArrayList<>();
        for (int indice : indices) {
            result.add(nge[indice]);
        }
        return result;
    }
    private void mergeSort(int start, int end, Pair[] array, Pair[] temp, int[] nge) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(start, mid, array, temp, nge);
        mergeSort(mid + 1, end, array, temp, nge);
        merge(start, mid, end, array, temp, nge);

    }
    private void merge(int start, int mid, int end, Pair[] array, Pair[] temp, int[] nge) {
        for (int i = start; i <= end; i++) {
            temp[i] = array[i];
        }
        int i = start, j = mid+1, k = start;
        while (i <= mid && j <= end && k <= end) {
            if (temp[i].value < temp[j].value) {
                nge[temp[i].index] += (end - j + 1);
                array[k] = temp[i];
                i++;
                k++;
            }
            else {
                array[k] = temp[j];
                j++;
                k++;
            }
        }
        while (i <= mid && k <= end) {
            array[k] = temp[i];
            i++;
            k++;
        }
        while (j <= end && k <= end) {
            array[k] = temp[j];
            j++;
            k++;
        }
    }
}
