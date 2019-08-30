package MergeKSortedLists;
/**
 * Assume m is lists.length and n is the average length of the linked lists.
 * Time Complexity: O(m + nmlogm)
 * Space Complexity: O(1)
 * Runtime: 16ms
 * Rank: 75.37%
 */
public class Solution1 {
	public ListNode mergeKLists(ListNode[] lists) {
		int k = lists.length;
		int i = 0, j = 0;
		while (j < k) {
			if (lists[j] != null) {
				lists[i] = lists[j];
				i += 1;
			}
			j += 1;
		}
		k = i;
		for (int t = (k - 2) / 2; t > -1; t--) {
			heapify(lists, k, t);
		}
		ListNode dummy = new ListNode(-1);
		ListNode worker = dummy;
		while (k > 0) {
			worker.next = lists[0];
			// worker.next = new ListNode(lists[0].val);
			worker = worker.next;
			if (lists[0].next == null) {
				swap(lists, 0, k - 1);
				k -= 1;
				heapify(lists, k, 0);
			} else {
				lists[0] = lists[0].next;
				heapify(lists, k, 0);
			}
		}
		return dummy.next;
	}

	public void swap(ListNode[] heap, int i, int j) {
		ListNode temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	public void heapify(ListNode[] heap, int k, int i) {
		while (true) {
			int minPos = i;
			if (i * 2 + 1 < k && heap[i].val > heap[i * 2 + 1].val) {
				minPos = i * 2 + 1;
			}
			if (i * 2 + 2 < k && heap[minPos].val > heap[i * 2 + 2].val) {
				minPos = i * 2 + 2;
			}
			if (minPos == i) {
				break;
			} else {
				swap(heap, i, minPos);
				i = minPos;
			}
		}
	}
}
