package __04__LinkedList;

public class Solution_18_RemoveNthNodeFromEnd_19 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    // Time complexity O(n)
    // Space complexity O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        int count = 1;
        while(curr != null) {
            if (count == n) {
                break;
            }
            count++;
            curr = curr.next;
        }
        // When length of list is greater than the given n
        if (curr == null) {
            return null;
        }
        ListNode node = head, prev = null;
        // edge case
        // when head needs to be deleted
        if (curr.next == null) {
            head = head.next;
        }
        else {
            while (curr.next != null) {
                prev = node;
                node = node.next;
                curr = curr.next;
            }
            prev.next = node.next;
        }
        return head;
    }
}
