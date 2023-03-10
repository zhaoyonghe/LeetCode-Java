package IntersectionOfTwoLinkedLists_160;

/**
 * Assume m, n are the length of listA and listB.
 * Time Complexity: O(m + n)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 98.85%
 */

public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int count = 0;
        while (a != b) {
            a = a.next;
            b = b.next;
            if (a == null) {
                if (count >= 2) {
                    return null;
                }
                a = headB;
                count++;
            }
            if (b == null) {
                if (count >= 2) {
                    return null;
                }
                b = headA;
                count++;
            }
        }
        return a;
    }
}
