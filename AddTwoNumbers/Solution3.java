package AddTwoNumbers;
/**
 * Assume n is the length of longest linked list.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 20ms
 * Rank: 92.25%
 */
public class Solution3 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode resulthead = new ListNode(0);
		ListNode curL1 = l1;
		ListNode curL2 = l2;
		ListNode curresult = resulthead;
		int carry = 0;
		while (curL1 != null || curL2 != null) {
			// These two lines of code must be at top of this while block but not at the end.
			// Because if at the end, we will generate a redundant list node which cannot be deleted and cause error.
			// Write these two lines of code here will make the first node redundant,
			// but the first node can be easily overlooked by returning the result from the second node. 
			curresult.next = new ListNode(0);
			curresult = curresult.next;
			
			int add1 = 0;
			int add2 = 0;
			if (curL1 != null) {
				add1 = curL1.val;
				curL1 = curL1.next;
			}
			if (curL2 != null) {
				add2 = curL2.val;
				curL2 = curL2.next;
			}
			int sum = add1 + add2 + carry;
			if (sum > 9) {
				sum -= 10;
				carry = 1;
			} else {
				carry = 0;
			}
			curresult.val = sum;
		}
		if (carry == 1) {
			curresult.next = new ListNode(1);
		}
		// Returning the result from the second node.
		return resulthead.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
