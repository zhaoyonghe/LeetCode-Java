package TopKFrequentElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Assume n is nums.length.
 * Time Complexity: O(n * logn)
 * Space Complexity: O(n)
 * Runtime: 49ms
 * Rank: 47.44%
 */
public class Solution1 {
	public List<Integer> topKFrequent(int[] nums, int k) {
		int n = nums.length;

		HashMap<Integer, Integer> map = new HashMap<>();

		int size = -1;

		int[] heap = new int[n];
		int[] count = new int[n];

		for (int num : nums) {
			int index;
			if (map.containsKey(num)) {
				index = map.get(num);
			} else {
				size += 1;
				index = size;
				map.put(num, index);
			}
			heap[index] = num;
			count[index] += 1;
			index = heapify(heap, count, map, index);
			map.put(num, index);

		}

		List<Integer> ret = new ArrayList<>(k);
		for (int i = 0; i < k; i++) {
			// System.out.println(i);
			ret.add(heap[0]);
			swap(heap, count, map, 0, size);
			size -= 1;
			dheapify(heap, count, map, size);
		}
		return ret;
	}

	public int heapify(int[] heap, int[] count, HashMap<Integer, Integer> map, int i) {
		while (i > 0) {
			if (count[(i - 1) / 2] < count[i]) {
				swap(heap, count, map, i, (i - 1) / 2);
				i = (i - 1) / 2;
			} else {
				break;
			}
		}
		return i;
	}

	public void dheapify(int[] heap, int[] count, HashMap<Integer, Integer> map, int size) {
		int i = 0;
		while (i <= size) {
			int index = i;
			if (i * 2 + 1 <= size && count[index] < count[i * 2 + 1]) {
				index = i * 2 + 1;
			}
			if (i * 2 + 2 <= size && count[index] < count[i * 2 + 2]) {
				index = i * 2 + 2;
			}
			if (index == i) {
				break;
			}
			swap(heap, count, map, index, i);
			i = index;
		}
	}

	public void swap(int[] heap, int[] count, HashMap<Integer, Integer> map, int i, int j) {
		map.put(heap[i], j);
		map.put(heap[j], i);

		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;

		temp = count[i];
		count[i] = count[j];
		count[j] = temp;
	}
}
