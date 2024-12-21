package O.OddEvenLinkedList;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 7ms
 * Rank: 26.90%
 */
public class Solution1 {
    public ListNode oddEvenList(ListNode head) {
        // divide the list into two lists and then merge them
        if (head == null) {
            return null;
        }
        ListNode ohead = new ListNode(0);
        ListNode ehead = new ListNode(0);
        ListNode curo = ohead;
        ListNode cure = ehead;
        ListNode worker1 = head;
        ListNode worker2 = worker1.next;
        int count = 1;
        ListNode cur = null;

        while (worker2 != null) {
            if ((count & 1) != 0) {
                // odd
                cur = curo;
            } else {
                // even
                cur = cure;
            }
            cur.next = worker1;
            worker1.next = null;
            cur = cur.next;
            worker1 = worker2;
            worker2 = worker2.next;
            if ((count & 1) != 0) {
                // odd
                curo = cur;
            } else {
                // even
                cure = cur;
            }
            count += 1;
        }

        if ((count & 1) != 0) {
            // odd
            cur = curo;
        } else {
            // even
            cur = cure;
        }
        cur.next = worker1;
        cur = cur.next;
        if ((count & 1) != 0) {
            // odd
            curo = cur;
        } else {
            // even
            cure = cur;
        }

        curo.next = ehead.next;
        return ohead.next;

    }
}
