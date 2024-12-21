package T.TrappingRainWater_42;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Assume n is the length of height.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 1ms
 * Rank: 82.04%
 */

public class Solution2 {
    public int trap(int[] height) {
        int res = 0;
        int n = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int bottom = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                res += (Math.min(height[left], height[i]) - height[bottom]) * (i - left - 1);
            }
            stack.push(i);
        }
        return res;
    }
}
