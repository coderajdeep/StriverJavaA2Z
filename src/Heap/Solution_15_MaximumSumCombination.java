package Heap;

import java.util.*;

public class Solution_15_MaximumSumCombination {
    private record Pair(int first, int second) {}
    private record PQ_Pair(int first, int second, int sum) {}
    public int[] maxSumCombinations(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        Integer[] arr1 = new Integer[n1];
        Integer[] arr2 = new Integer[n2];
        for (int i=0; i<n1; i++) {
            arr1[i] = nums1[i];
        }
        for (int i=0; i<n2; i++) {
            arr2[i] = nums2[i];
        }
        Arrays.sort(arr1, (a, b) -> b - a);
        Arrays.sort(arr2, (a, b) -> b - a);
        Set<Pair> set = new HashSet<>();
        PriorityQueue<PQ_Pair> pq = new PriorityQueue<> ((a, b) -> b.sum() - a.sum());
        pq.offer(new PQ_Pair(n1-1, n2-1, arr1[n1-1] + arr2[n2-1]));
        set.add(new Pair(n1-1, n2-1));

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty() && k>0) {
            PQ_Pair pq_pair = pq.poll();
            result.add(pq_pair.sum());
            int x1 = pq_pair.first();
            int x2 = pq_pair.second()-1;
            if (x1>=0 && x2>=0 && !set.contains(new Pair(x1, x2))) {
                pq.offer(new PQ_Pair(x1, x2, arr1[x1] + arr2[x2]));
                set.add(new Pair(x1, x2));
            }
            int y1 = pq_pair.first()-1;
            int y2 = pq_pair.second();
            if (y1>=0 && y2>=0 && !set.contains(new Pair(y1, y2))) {
                pq.offer(new PQ_Pair(y1, y2, arr1[y1] + arr2[y2]));
                set.add(new Pair(y1, y2));
            }
            k--;
        }
        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
