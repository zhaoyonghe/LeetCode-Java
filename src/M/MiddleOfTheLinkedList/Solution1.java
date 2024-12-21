package M.MiddleOfTheLinkedList;

/**
 * Assume n is the length of the list.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 100.00%
 */
public class Solution1 {
    public ListNode middleNode(ListNode head) {
        ListNode ready = new ListNode(-1);
        ready.next = head;
        ListNode fast = ready;
        ListNode slow = ready;
        while (true) {
            try {
                fast = fast.next;
                try {
                    fast = fast.next;
                } catch (Exception e) {
                    slow = slow.next;
                    break;
                }
            } catch (Exception e) {
                break;
            }
            slow = slow.next;
        }
        return slow;
    }
}
