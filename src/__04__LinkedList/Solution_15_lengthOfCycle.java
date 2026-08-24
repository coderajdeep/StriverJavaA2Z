package __04__LinkedList;

public class Solution_15_lengthOfCycle {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
            val = 0;
            next = null;
        }

        ListNode(int data1) {
            val = data1;
            next = null;
        }

        ListNode(int data1, ListNode next1) {
            val = data1;
            next = next1;
        }
    }
    // Time complexity O(n)
    // Space complexity O(1)
    public int findLengthOfLoop(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int length = 1;
                fast = fast.next;
                while (fast != slow) {
                    ++length;
                    fast = fast.next;
                }
                return length;
            }
        }
        return 0;
    }
}
