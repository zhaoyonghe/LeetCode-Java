package I.IntersectionOfTwoLinkedLists_160;

import java.util.HashSet;
import java.util.Set;

/**
 * Assume m, n are the length of listA and listB.
 * Time Complexity: O(m + n)
 * Space Complexity: O(m)
 * Runtime: 16ms
 * Rank: 8.70%
 */

public class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = headA;
        while (cur != null) {
            set.add(cur);
            cur = cur.next;
        }
        cur = headB;
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}
