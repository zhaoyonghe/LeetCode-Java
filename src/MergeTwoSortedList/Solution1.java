package MergeTwoSortedList;

/**
 * Assume the length of l1 is m, that of l2 is n.
 * Time Complexity: O(m + n)
 * Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curResult = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curResult.next = l1;
                l1 = l1.next;
                curResult = curResult.next;
            } else {
                curResult.next = l2;
                l2 = l2.next;
                curResult = curResult.next;
            }
        }
        if (l1 == null) {
            curResult.next = l2;
        } else {
            curResult.next = l1;
        }
        return dummy.next;
    }
}
