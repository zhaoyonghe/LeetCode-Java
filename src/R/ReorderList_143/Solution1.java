package R.ReorderList_143;

/**
 * $$ Assume n is the length of the list.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(1)
 */

public class Solution1 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        // Only modify list with more than three nodes.
        ListNode[] splited = split(head);
        ListNode reversed = reverse(splited[1]);
        merge(splited[0], reversed);
    }

    private ListNode[] split(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode[] res = new ListNode[]{head, slow.next};
        slow.next = null;
        return res;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // List has at least two nodes.
        ListNode a = head, b = head.next, newHead = null;
        while (b != null) {
            a.next = newHead;
            newHead = a;
            a = b;
            b = b.next;
        }
        a.next = newHead;
        return a;
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (a != null && b != null) {
            tail.next = a;
            tail = tail.next;
            a = a.next;
            tail.next = b;
            tail = tail.next;
            b = b.next;
        }
        if (a != null) {
            tail.next = a;
        }
        return dummy.next;
    }
}