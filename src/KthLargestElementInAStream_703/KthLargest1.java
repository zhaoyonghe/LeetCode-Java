package KthLargestElementInAStream_703;

import java.util.PriorityQueue;

/**
 * Assume nums.length is n.
 * Constructor Time Complexity: O(n)
 * add() Time Complexity: O(log(n))
 * Space Complexity: O(n)
 * Runtime: 11ms
 * Rank: 96.89%
 */
public class KthLargest1 {
    private final int k;
    private final PriorityQueue<Integer> pq = new PriorityQueue();

    public KthLargest1(int k, int[] nums) {
        this.k = k;
        for (int n : nums) {
            add(n);
        }
    }

    // It is guaranteed that there will be at least k elements in the array when you search for the kth element.
    // (if called by user, add will always return the kth element)
    public int add(int val) {
        pq.offer(val);
        if (pq.size() == k + 1) {
            pq.poll();
        }
        // 1 <= k <= 10 ^ 4, pq.peek() cannot be null.
        return pq.peek();
    }
}