package FindMedianFromDataStream;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Assume n is the size of the heap.
 * Constructor Time Complexity: O(1)
 * addNum Time Complexity: O(logn)
 * findMedian Time Complexity: O(1)
 * Space Complexity: O(n)
 * Runtime: 163ms
 * Rank: 99.43%
 */

public class MedianFinder {
	PriorityQueue<Integer> maxHeap = null;
	PriorityQueue<Integer> minHeap = null;

	/** initialize your data structure here. */
	public MedianFinder() {
		Comparator<Integer> comparator = new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i2 - i1;
			}
		};
		maxHeap = new PriorityQueue<Integer>(comparator);
		minHeap = new PriorityQueue<Integer>();
	}

	public void addNum(int num) {
		// abs(maxSz - minSz) will always be less or equals than 1
		int maxSz = maxHeap.size();
		int minSz = minHeap.size();

		if (maxSz == 0) {
			maxHeap.add(num);
			return;
		}

		if (num <= maxHeap.peek()) {
			// num should in the smaller half
			if (maxSz > minSz) {
				int temp = maxHeap.poll();
				minHeap.add(temp);
			}
			maxHeap.add(num);
			return;
		}
		
		if (minSz == 0) {
			minHeap.add(num);
			return;
		}

		if (num >= minHeap.peek()) {
			// num should in the bigger half
			if (minSz > maxSz) {
				int temp = minHeap.poll();
				maxHeap.add(temp);
			}
			minHeap.add(num);
			return;
		}

		if (maxHeap.peek() < num && num < minHeap.peek()) {
			if (maxSz <= minSz) {
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}
		}
	}

	public double findMedian() {
		int maxSz = maxHeap.size();
		int minSz = minHeap.size();
		int sumSz = maxSz + minSz;

		if ((sumSz & 1) == 0) {
			// even
			return (double) (maxHeap.peek() + minHeap.peek()) / 2;
		} else {
			// odd
			if (maxSz > minSz) {
				return (double) maxHeap.peek();
			} else {
				return (double) minHeap.peek();
			}
		}

	}
	
	public static void main(String[] args) {
		MedianFinder medianFinder = new MedianFinder();
		medianFinder.addNum(1);
		medianFinder.addNum(2);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(3);
		System.out.println(medianFinder.findMedian());
	}
}
