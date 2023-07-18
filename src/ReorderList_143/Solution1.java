package ReorderList_143;

public class Solution1 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        // Split head into two linked lists.
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy, slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode a = dummy.next;
        ListNode b = slow.next;
        slow.next = null;

        // Reverse b.
        b = reverse(b);

        // Combine a and b.
        // a == head
        dummy.next = null;
        slow = dummy;
        boolean flag = true;
        while (a != null || b != null) {
            if (flag) {
                slow.next = a;
                a = a.next;
            } else {
                slow.next = b;
                b = b.next;
            }
            slow = slow.next;
            slow.next = null;
            flag = !flag;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode a = head, b = head.next;
        ListNode newHead = null;
        while (a != null) {
            a.next = newHead;
            newHead = a;
            a = b;
            if (b != null) {
                b = b.next;
            }
        }
        return newHead;
    }
}