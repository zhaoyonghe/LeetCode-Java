package AddTwoNumbers_2;
/**
 * Assume n is the length of longest linked list.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 1ms
 * Rank: 100.00%
 */

public class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            carry = sum / 10;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
