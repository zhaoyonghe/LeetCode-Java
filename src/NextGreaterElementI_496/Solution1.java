package NextGreaterElementI_496;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(nums2.length)
 * Space Complexity: O(nums2.length)
 * Runtime: 3ms
 * Rank: 83.63%
 */
public class Solution1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            m.put(nums1[i], i);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nums1.length];
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            if (m.containsKey(nums2[i])) {
                res[m.get(nums2[i])] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nums2[i]);
        }

        return res;
    }
}
