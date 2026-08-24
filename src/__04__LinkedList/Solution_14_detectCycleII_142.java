package __04__LinkedList;

import java.util.HashSet;
import java.util.Set;

public class Solution_14_detectCycleII_142 {
    public static final class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    // Time complexity O(n)
    // Space complexity O(n)
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
    // Time complexity O(n)
    // Space complexity O(1)
    // Slow and fast pointer approach
    // Intuition : Lets say, slow is in the starting point in the loop and distance covered is l
    // then fast will be at distance l from slow (slow to fast distance)
    // lets say, distance from fast to slow is d (fast to slow distance)
    // So the loop length is l + d
    // Now, when fast and slow start moving, fast will cover 2 nodes and slow will cover 1 node
    // Distance will be reduced by 1 in each step, so after d steps, they will meet
    // So when fast and slow meet, distance covered by slow is d
    // so from meeting point to loop starting distance is (l+d)-d = l
    // Hence if slow starts from head and fast starts from meeting point
    // And they cover 1 node at a time then they will meet at the starting point of loop
    public ListNode detectCycleBestSolution(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                slow = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
