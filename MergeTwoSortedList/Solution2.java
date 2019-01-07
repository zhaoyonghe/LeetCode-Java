package MergeTwoSortedList;
/**
 * Time Complexity: O(the sum of length of l1 and l2)
 * Space Complexity: O(1)
 * Runtime: 9ms
 * Rank: 92.90%
 */
public class Solution2 {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
