package N.NextGreaterElementII_503;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Time Complexity: O(nums.length)
 * Space Complexity: O(nums.length)
 * Runtime: 5ms
 * Rank: 96.68%
 */

public class Solution1 {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        return res;
    }
}
