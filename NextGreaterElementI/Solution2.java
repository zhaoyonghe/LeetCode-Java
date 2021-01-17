package NextGreaterElementI;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Time Complexity: O(nums1.length + nums2.length)
 * Space Complexity: O(nums2.length)
 * Runtime: 7ms
 * Rank: 83.48%
 */

class Solution2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return new int[]{};
        }

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        int n2 = nums2.length;

        stack.push(nums2[n2 - 1]);
        map.put(nums2[n2 - 1], n2 - 1);
        nums2[n2 - 1] = -1;

        for (int i = n2 - 2; i >= 0; i--) {
            map.put(nums2[i], i);
            if (nums2[i] < stack.peek()) {
                int temp = nums2[i];
                nums2[i] = stack.peek();
                stack.push(temp);
            } else {
                // nums2[i] > stack.peek()
                while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    stack.push(nums2[i]);
                    nums2[i] = -1;
                } else {
                    int temp = nums2[i];
                    nums2[i] = stack.peek();
                    stack.push(temp);
                }
            }
        }

        int n1 = nums1.length;
        int[] result = new int[n1];

        for (int i = 0; i < n1; i++) {
            result[i] = nums2[map.get(nums1[i])];
        }

        return result;
    }
}