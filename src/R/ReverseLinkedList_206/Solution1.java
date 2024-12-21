package R.ReverseLinkedList_206;

/**
 * $$ Time Complexity: O(the length of the list)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        ListNode a = head, b = head.next;
        while (b != null) {
            a.next = newHead;
            newHead = a;
            a = b;
            b = b.next;
        }
        a.next = newHead;
        return a;
    }
}
