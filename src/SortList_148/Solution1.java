package SortList_148;

/**
 * Assume n is the length of the linked list.
 * Time Complexity: O(nlogn)
 * Space Complexity: O(1)
 * Runtime: 5ms
 * Rank: 99.00%
 */

public class Solution1 {
    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
                continue;
            }
            cur.next = l2;
            cur = cur.next;
            l2 = l2.next;
        }

        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }

        return head.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;
        return merge2Lists(sortList(head), sortList(tmp));
    }
}
