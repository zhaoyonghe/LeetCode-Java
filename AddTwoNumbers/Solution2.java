package AddTwoNumbers;
/**
 * Assume n is the length of longest linked list.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 24ms
 * Rank: 71.57%
 */
import AddTwoNumbers.ListNode;

public class Solution2 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode resulthead = new ListNode(0);
		resulthead.next = new ListNode(0);
		ListNode curresult = resulthead;
		ListNode curL1 = l1;
		ListNode curL2 = l2;
		while (curL1 != null && curL2 != null) {
			curresult = curresult.next;
			curresult.val = curresult.val + curL1.val + curL2.val;
			if(curresult.val > 9) {
				curresult.val -= 10;
				curresult.next = new ListNode(1);
			}else {
				curresult.next = new ListNode(0);
			}
			
			curL1 = curL1.next;
			curL2 = curL2.next;
		}
		if(curL1 == null && curL2 == null) {
			if(curresult.next.val == 0) {
				curresult.next = null;
			}
			return resulthead.next;
		}
		if(curL1 == null) {
			if(curresult.next.val == 0) {
				curresult.next = curL2;
				return resulthead.next;
			} else {
				curresult.next = addTwoNumbers(curresult.next, curL2);
				return resulthead.next;
			}
		}
		if(curL2 == null) {
			if(curresult.next.val == 0) {
				curresult.next = curL1;
				return resulthead.next;
			} else {
				curresult.next = addTwoNumbers(curresult.next, curL1);
				return resulthead.next;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
