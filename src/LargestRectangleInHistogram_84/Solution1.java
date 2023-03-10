package LargestRectangleInHistogram_84;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Assume heights.length is n.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 16ms
 * Rank: 87.39%
 */

public class Solution1 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int h = heights[stack.pop()];
                int w = i - (stack.isEmpty() ? 0 : stack.peek() + 1);
                res = Math.max(res, h * w);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int w = heights.length - (stack.isEmpty() ? 0 : stack.peek() + 1);
            res = Math.max(res, h * w);
        }
        return res;
    }
}
