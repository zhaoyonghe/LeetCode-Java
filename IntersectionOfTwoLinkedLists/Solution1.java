package IntersectionOfTwoLinkedLists;
/**
 * Time Complexity: O(the sum of the length of the linked list A and B)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 100.00%
 */
public class Solution1 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		int lenA = 1;
		int lenB = 1;
		ListNode tempA = headA;
		ListNode tempB = headB;
		while (tempA.next != null) {
			tempA = tempA.next;
			lenA += 1;
		}
		while (tempB.next != null) {
			tempB = tempB.next;
			lenB += 1;
		}
		tempA = headA;
		tempB = headB;
		if (lenA > lenB) {
			int offset = lenA - lenB;
			for (int i = 0; i < offset; i++) {
				tempA = tempA.next;
			}
		}
		if (lenA < lenB) {
			int offset = lenB - lenA;
			for (int i = 0; i < offset; i++) {
				tempB = tempB.next;
			}
		}
		while (tempA != null) {
			if (tempA == tempB) {
				return tempA;
			}
			tempA = tempA.next;
			tempB = tempB.next;
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
