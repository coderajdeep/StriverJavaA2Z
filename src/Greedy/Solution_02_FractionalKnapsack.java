package Greedy;

import java.util.Arrays;

public class Solution_02_FractionalKnapsack {
    private static class Item {
        int value;
        int weight;
        Item(int v, int w) {
            value = v;
            weight = w;
        }
    }
    public double fractionalKnapsack(int[] val, int[] wt, long cap) {
        int n = val.length;
        Item[] items = new Item[n];
        for (int i=0; i<n; i++) {
            items[i] = new Item(val[i], wt[i]);
        }
        Arrays.sort(items, (a, b) -> {
            double r1 = (double) a.value / a.weight;
            double r2 = (double) b.value / b.weight;
            return Double.compare(r2, r1);
        });
        double total = 0;
        for (Item item : items) {
            if (item.weight <= cap) {
                total += item.value;
                cap -= item.weight;
            }
            else {
                total += ((((double) item.value) / item.weight) * cap);
                break;
            }
        }
        return total;
    }
}
