package MergeTwoSortedList;
/**
 * Time Complexity: O(the sum of length of l1 and l2)
 * Space Complexity: O(1)
 * Runtime: 15ms
 * Rank: 65.43%
 */
public class Solution1 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		} else if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}
		ListNode temp1 = l1;
		ListNode temp2 = l2;
		ListNode result = null;
		if (temp1.val < temp2.val) {
			result = temp1;
			temp1 = temp1.next;
		} else {
			result = temp2;
			temp2 = temp2.next;
		}
		ListNode curResult = result;
		while (temp1 != null && temp2 != null) {
			if (temp1.val < temp2.val) {
				curResult.next = temp1;
				temp1 = temp1.next;
				curResult = curResult.next;
			} else {
				curResult.next = temp2;
				temp2 = temp2.next;
				curResult = curResult.next;
			}
		}
		if (temp1 == null) {
			curResult.next = temp2;
		} else {
			curResult.next = temp1;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
