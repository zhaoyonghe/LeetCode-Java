package DesignCircularDeque;

/**
 * insertFront() Time Complexity: O(1)
 * insertLast() Time Complexity: O(1)
 * deleteFront() Time Complexity: O(1)
 * deleteLast() Time Complexity: O(1)
 * getFront() Time Complexity: O(1)
 * getRear() Time Complexity: O(1)
 * isEmpty() Time Complexity: O(1)
 * isFull() Time Complexity: O(1)
 * Space Complexity: O(k)
 * Runtime: 101ms
 * Rank: 66.47%
 */
public class Solution1 {
    class MyCircularDeque {
        private final int qlen;
        private int[] queue;
        private int start;
        private int end;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            qlen = k + 1;
            queue = new int[qlen];
            start = 0;
            end = 0;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is
         * successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            } else {
                start = (start - 1 + qlen) % qlen;
                queue[start] = value;
                return true;
            }
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is
         * successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            } else {
                queue[end] = value;
                end = (end + 1) % qlen;
                return true;
            }
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is
         * successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            } else {
                start = (start + 1) % qlen;
                return true;
            }
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is
         * successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            } else {
                end = (end - 1 + qlen) % qlen;
                return true;
            }
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            } else {
                return queue[start];
            }
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            } else {
                return queue[(end - 1 + qlen) % qlen];
            }
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return start == end;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return (end + 1) % qlen == start;
        }
    }
}
