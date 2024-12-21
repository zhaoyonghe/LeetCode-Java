package M.MergeTwoSortedList_21;

/**
 * $$ Assume the length of l1 is m, that of l2 is n.
 * $$ Time Complexity: O(m + n)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode l1 = list1;
        ListNode l2 = list2;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
                continue;
            }
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
