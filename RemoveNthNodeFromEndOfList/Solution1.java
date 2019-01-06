package RemoveNthNodeFromEndOfList;
/**
 * Time Complexity: O(the length of linked list)
 * Space Complexity: O(1)
 * Runtime: 15ms
 * Rank: 66.39%
 */
public class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode readyNode = new ListNode(-1);
    	readyNode.next = head;
        ListNode fast = readyNode;
        ListNode slow = readyNode;
        for(int i = 0; i < n; i++) {
        	fast = fast.next;
        }
        while(fast.next != null) {
        	fast = fast.next;
        	slow = slow.next;
        }
        slow.next = slow.next.next;
        return readyNode.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
