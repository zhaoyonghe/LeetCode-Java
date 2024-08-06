package PalindromeLinkedList_234;

/**
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public boolean isPalindrome(ListNode head) {
        return compare(head, reverse(head));
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = new ListNode(head.val, newHead);
            newHead = tmp;
            head = head.next;
        }
        return newHead;
    }

    private boolean compare(ListNode a, ListNode b) {
        while (a != null && b != null) {
            if (a.val == b.val) {
                a = a.next;
                b = b.next;
                continue;
            }
            return false;
        }
        return true;
    }
}
