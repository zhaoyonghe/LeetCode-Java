package ImplementQueueUsingStacks;

/**
 * push Time Complexity: O(1)
 * pop Time Complexity: O(size)
 * peek Time Complexity: O(1)
 * empty Time Complexity: O(1)
 * Space Complexity: O(max size)
 * Runtime: 87ms
 * Rank: 65.93%
 */
public class Solution1 {
    class MyQueue {
        // When popping, use an auxiliary stack to reverse the stack.
        public int capacity = 16;
        public int[] stack = null;
        public int[] aux = null;
        public int end = 0;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack = new int[capacity];
            aux = new int[capacity];
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            if (end == capacity) {
                capacity *= 2;
                aux = new int[capacity];
                int[] temp = new int[capacity];
                for (int i = 0; i <= end; i++) {
                    temp[i] = stack[i];
                }
                stack = temp;
                stack[end] = x;
                end += 1;
            } else {
                stack[end] = x;
                end += 1;
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (empty()) {
                return -1;
            } else {
                for (int i = end - 1; i > -1; i--) {
                    aux[end - 1 - i] = stack[i];
                }
                int record = aux[end - 1];
                end -= 1;
                for (int i = end - 1; i > -1; i--) {
                    stack[end - 1 - i] = aux[i];
                }
                return record;
            }
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return stack[0];
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return end == 0;
        }
    }

}
