package LargestRectangleInHistogram_84;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * $$ Assume heights.length is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */

public class Solution1 {
    public int largestRectangleArea(int[] heights) {
        int[] width = new int[heights.length];

        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i <= heights.length; i++) {
            cal(st, i, heights, width);
        }
        st.clear();
        for (int i = heights.length - 1; i >= -1; i--) {
            cal(st, i, heights, width);
        }
        int max = 0;
        for (int i = 0; i < width.length; i++) {
            max = Math.max(max, heights[i] * (width[i] + 1));
        }
        return max;
    }

    private void cal(Deque<Integer> st, int hi, int[] heights, int[] width) {
        while (!st.isEmpty() && heights[st.peek()] > getHeight(heights, hi)) {
            width[st.peek()] += Math.abs(hi - st.peek()) - 1;
            st.pop();
        }
        st.push(hi);
    }

    private int getHeight(int[] heights, int hi) {
        if (hi < 0 || hi >= heights.length) {
            return 0;
        }
        return heights[hi];
    }
}
