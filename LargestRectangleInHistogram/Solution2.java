package LargestRectangleInHistogram;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Assume heights.length is n.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 15ms
 * Rank: 87.80%
 */
public class Solution2 {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> indexStack = new ArrayDeque<>();
        indexStack.push(-1);

        for (int i = 0; i < heights.length; i++) {
            while (indexStack.peek() != -1 && heights[indexStack.peek()] > heights[i]) {
                int h = heights[indexStack.pop()];
                res = Math.max(res, h * (i - indexStack.peek() - 1));
            }
            indexStack.push(i);
        }

        while (indexStack.peek() != -1 && heights[indexStack.peek()] > 0) {
            int index = indexStack.pop();
            int h = heights[index];
            res = Math.max(res, h * (heights.length - indexStack.peek() - 1));
        }

        return res;
    }
}
