package R.ReverseNodesInKGroup_25;

/**
 * $$ Assume n is the length of head.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(k)
 */

public class Solution1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode a = head, b = head;
        ListNode newHead = new ListNode(0), newTail = newHead;
        while (true) {
            // reverse a group
            ListNode groupHead = null, groupTail = a;
            int linked = 0;
            while (linked < k && a != null) {
                b = b.next;
                a.next = groupHead;
                groupHead = a;
                a = b;
                linked++;
            }
            if (linked == k) {
                newTail.next = groupHead;
                newTail = groupTail;
            } else {
                newTail.next = reverse(groupHead);
                break;
            }
        }
        return newHead.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode a = head, b = head, top = null;
        while (a != null) {
            b = b.next;
            a.next = top;
            top = a;
            a = b;
        }
        return top;
    }
}