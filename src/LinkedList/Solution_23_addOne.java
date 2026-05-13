package LinkedList;

public class Solution_23_addOne {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
            val = 0;
            next = null;
        }

        ListNode(int data) {
            val = data;
            next = null;
        }

        ListNode(int data, ListNode next) {
            val = data;
            this.next = next;
        }
    }

    // Time complexity O(n)
    // Space complexity O(1)
    public ListNode addOne(ListNode head) {
        ListNode curr = reverseLinkedList(head), currStore = curr;
        int carry = 1;
        while (curr != null) {
            int sum = curr.val + carry;
            carry = sum / 10;
            curr.val = sum % 10;
            if (carry == 0) {
                break;
            }
            if (curr.next == null) {
                curr.next = new ListNode(carry);
                break;
            }
            curr = curr.next;
        }
        return reverseLinkedList(currStore);
    }
    private ListNode reverseLinkedList(ListNode head) {
        ListNode next = null, prev = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
