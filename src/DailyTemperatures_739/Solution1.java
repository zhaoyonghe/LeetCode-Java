package DailyTemperatures_739;

import java.util.*;

/**
 * Assume the length of T is n.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 12ms
 * Rank: 90.71%
 */

public class Solution1 {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return res;
    }
}
