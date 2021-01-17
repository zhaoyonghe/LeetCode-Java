package ConvertSortedListToBinarySearchTree;

/**
 * Assume the length of the linked list is n.
 * Time Complexity: O(nlogn)
 * Space Complexity: O(logn)
 * Runtime: 1ms
 * Rank: 99.94%
 */
public class Solution1 {
    public TreeNode sortedListToBST(ListNode head) {
        // 0 node
        if (head == null) {
            return null;
        }
        // 1 node
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        // 2 nodes
        if (head.next.next == null) {
            TreeNode temp = new TreeNode(head.val);
            temp.right = new TreeNode(head.next.val);
            return temp;
        }

        // 3 ore more nodes
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode sslow = dummy;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            sslow = sslow.next;
        }

        sslow.next = null;
        dummy.next = null;

        TreeNode temp = new TreeNode(slow.val);
        slow = slow.next;
        temp.left = sortedListToBST(head);
        temp.right = sortedListToBST(slow);

        return temp;
    }
}
