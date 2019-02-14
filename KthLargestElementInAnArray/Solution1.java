package KthLargestElementInAnArray;
/**
 * Time Complexity: O(k + (n - k)logk)
 * Space Complexity: O(k)
 * Runtime: 3ms
 * Rank: 99.94%
 */
public class Solution1 {
	public int findKthLargest(int[] nums, int k) {
		int[] heap = new int[k + 1];
		for (int i = 0; i < k; i++) {
			heap[i + 1] = nums[i];
		}
		for (int i = k / 2; i > 0; i--) {
			heapify(heap, k, i);
		}
		for (int i = k; i < nums.length; i++) {
			if (nums[i] > heap[1]) {
				heap[1] = nums[i];
				heapify(heap, k, 1);
			}
		}
		return heap[1];
	}

	public void swap(int[] heap, int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	public void heapify(int[] heap, int k, int i) {
		// node i must have children
		while (true) {
			int minPos = i;
			if (i * 2 <= k && heap[i] >= heap[i * 2]) {
				minPos = i * 2;
			}
			if (i * 2 + 1 <= k && heap[minPos] >= heap[i * 2 + 1]) {
				minPos = i * 2 + 1;
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
