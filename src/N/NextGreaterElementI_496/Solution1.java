package N.NextGreaterElementI_496;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * $$ Time Complexity: O(nums2.length)
 * $$ Space Complexity: O(nums2.length)
 */
public class Solution1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            m.put(nums1[i], i);
        }

        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!st.isEmpty() && st.peek() < nums2[i]) {
                int num = st.pop();
                if (m.containsKey(num)) {
                    res[m.get(num)] = nums2[i];
                }
            }
            st.push(nums2[i]);
        }
        return res;
    }
}
