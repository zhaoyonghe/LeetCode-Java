package MergeKSortedLists;
/**
 * Time Complexity: O(m + nmlogm)
 * Space Complexity: O(1)
 * Runtime: 9ms
 * Rank: 95.92%
 */
public class Solution2 {
	public ListNode merge2Lists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode worker = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				worker.next = l1;
				l1 = l1.next;
				worker = worker.next;
			} else {
				worker.next = l2;
				l2 = l2.next;
				worker = worker.next;
			}
		}
		if (l1 == null) {
			worker.next = l2;
		} else {
			worker.next = l1;
		}
		return dummy.next;
	}

	public ListNode mergeKLists(ListNode[] lists) {
		int k = lists.length;
		if (k == 0) {
			return null;
		}
		while (k != 1) {
			for (int i = 0; i < k / 2; i++) {
				lists[i] = merge2Lists(lists[i * 2], lists[i * 2 + 1]);
			}
			if (k % 2 == 0) {
				k = k / 2;
			} else {
				lists[k / 2] = lists[k - 1];
				k = k / 2 + 1;
			}
		}
		return lists[0];
	}
}
