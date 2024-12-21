package B.BuildingsWithAnOceanView_1762;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * $$ Assume n is heights.length.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public int[] findBuildings(int[] heights) {
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (st.isEmpty() || heights[st.peek()] < heights[i]) {
                st.push(i);
            }
        }
        int[] res = new int[st.size()];
        int i = 0;
        while (!st.isEmpty()) {
            res[i++] = st.pop();
        }
        return res;
    }
}