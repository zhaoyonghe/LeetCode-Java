package I.IntersectionOfTwoLinkedLists_160;

/**
 * $$ Assume m, n are the length of listA and listB.
 * $$ Time Complexity: O(m + n)
 * $$ Auxiliary Space Complexity: O(1)
 */

public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        int changes = 0;
        while (a != b) {
            a = a.next;
            b = b.next;
            if (a == null || b == null) {
                changes++;
                if (changes > 2) {
                    return null;
                }
                if (a == null) {
                    a = headB;
                }
                if (b == null) {
                    b = headA;
                }
            }
        }
        return a;
    }
}
