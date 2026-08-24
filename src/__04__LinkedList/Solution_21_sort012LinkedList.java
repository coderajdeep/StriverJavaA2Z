package __04__LinkedList;

public class Solution_21_sort012LinkedList {
    public static class ListNode {
        int data;
        ListNode next;

        ListNode() {}

        ListNode(int data) {
            this.data = data;
        }

        ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }
    // Time complexity O(n)
    // Space complexity O(1)
    public ListNode sortList(ListNode head) {
        int zero = 0, one = 0, two = 0;
        ListNode curr = head;
        while (curr != null) {
            if (curr.data == 0) zero++;
            else if (curr.data == 1) one++;
            else if (curr.data == 2) two++;
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            if (zero != 0) {
                curr.data = 0;
                zero--;
            }
            else if (one != 0) {
                curr.data = 1;
                one--;
            }
            else if (two != 0) {
                curr.data = 2;
                two--;
            }
            curr = curr.next;
        }
        return head;
    }
}
