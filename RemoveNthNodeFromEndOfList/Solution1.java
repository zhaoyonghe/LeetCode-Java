package RemoveNthNodeFromEndOfList;

/**
 * Assume n is the length of linked list.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 15ms
 * Rank: 66.39%
 */
public class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // If fast and slow are not set on the readyNode, but on head node instead, 
        // in the case that n is equal to the length of linked list, 
        // we cannot delete the required node(head node) easily, 
        // because slow is stand on that node and we need the previous node of that node.
        // Thus, slow need to be initialized on a node previous to head node.
        // When slow and fast stop moving, 
        // fast stands on the last node and slow stands on the previous node of required node.
        // At last, slow is n nodes previous fast.
        ListNode readyNode = new ListNode(-1);
        readyNode.next = head;
        ListNode fast = readyNode;
        ListNode slow = readyNode;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return readyNode.next;
    }
}
