package RemoveNthNodeFromEndOfList;

/**
 * $$ Assume n is the length of linked list.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = dummy;

        while (n > 0) {
            // n <= list size, so fast will never be null
            fast = fast.next;
            n--;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // n > 0, so slow.nex will never be null
        slow.next = slow.next.next;
        return dummy.next;
    }
}
