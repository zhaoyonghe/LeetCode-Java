package D.DailyTemperatures_739;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * $$ Assume the length of temperatures is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */

public class Solution1 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> st = new ArrayDeque<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                res[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }
        return res;
    }
}
