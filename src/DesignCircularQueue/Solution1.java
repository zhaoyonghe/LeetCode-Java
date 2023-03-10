package DesignCircularQueue;

/**
 * enQueue() Time Complexity: O(1)
 * deQueue() Time Complexity: O(1)
 * Front() Time Complexity: O(1)
 * Rear() Time Complexity: O(1)
 * isEmpty() Time Complexity: O(1)
 * isFull() Time Complexity: O(1)
 * Space Complexity: O(k)
 * Runtime: 101ms
 * Rank: 66.47%
 */
public class Solution1 {
    // The implement of circular queue wastes a place in the array, but can avoid data movement.
    class MyCircularQueue {
        private final int qlen;
        private int[] queue;
        private int start;
        private int end;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            qlen = k + 1;
            queue = new int[qlen];
            start = 0;
            end = 0;
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is
         * successful.
         */
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            } else {
                queue[end] = value;
                end = (end + 1) % qlen;
                return true;
            }
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is
         * successful.
         */
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            } else {
                start = (start + 1) % qlen;
                return true;
            }
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if (isEmpty()) {
                return -1;
            } else {
                return queue[start];
            }
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if (isEmpty()) {
                return -1;
            } else {
                // The element BEFORE queue[end] !!!
                // Not queue[end - 1] !!!
                return queue[(end - 1 + qlen) % qlen];
            }
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return start == end;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return (end + 1) % qlen == start;
        }
    }
}
