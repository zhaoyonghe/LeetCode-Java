package FindMedianFromDataStream_295;

import java.util.PriorityQueue;

/**
 * Assume n is the size of the heap.
 * Constructor Time Complexity: O(1)
 * addNum Time Complexity: O(logn)
 * findMedian Time Complexity: O(1)
 * Space Complexity: O(n)
 * Runtime: 87ms
 * Rank: 84.55%
 */

public class MedianFinder1 {
    // Important constraints:
    // -10^5 <= num <= 10^5 (two-numbers-minus will not overflow)
    // There will be at least one element in the data structure before calling findMedian. (calls are always valid)
    private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> -Integer.compare(a, b));
    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));

    public MedianFinder1() {
        maxHeap.offer(Integer.MIN_VALUE);
        minHeap.offer(Integer.MAX_VALUE);
    }

    public void addNum(int num) {
        // maxHeap.size() == n, minHeap.size() == n
        // or maxHeap.size() == n, minHeap.size() == n + 1
        if (maxHeap.peek() <= num) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }
        if (minHeap.size() - maxHeap.size() == 2) {
            maxHeap.offer(minHeap.poll());
        }
        if (maxHeap.size() - minHeap.size() == 1) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if ((maxHeap.size() + minHeap.size()) % 2 == 0) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        }
        return (double) (minHeap.peek());
    }
}
