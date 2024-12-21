package B.BuildingsWithAnOceanView_1762;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * Assume n is heights.length.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 20ms
 * Rank: 36.04%
 */
public class Solution1 {
    public int[] findBuildings(int[] heights) {
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] <= heights[i]) {
                st.pop();
            }
            st.push(i);
        }
        int[] res = new int[st.size()];
        Iterator<Integer> it = st.descendingIterator();
        int i = 0;
        while (it.hasNext()) {
            res[i] = it.next();
            i++;
        }
        return res;
    }
}