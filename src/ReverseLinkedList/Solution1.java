package ReverseLinkedList;

/**
 * Time Complexity: O(the length of the list)
 * Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
    public ListNode reverseList(ListNode head) {
        // use a to take apart the head node
        // use b to mark the next node to take apart
        // all nodes will be linked on stub
        if (head == null) {
            return null;
        }
        ListNode stub = null;
        ListNode newhead = stub;
        ListNode a = head;
        ListNode b = a.next;
        while (b != null) {
            a.next = newhead;
            newhead = a;
            a = b;
            b = b.next;
        }
        a.next = newhead;
        newhead = a;
        return newhead;
    }
}
