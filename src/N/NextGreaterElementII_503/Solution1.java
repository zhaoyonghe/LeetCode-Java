package N.NextGreaterElementII_503;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * $$ Time Complexity: O(nums.length)
 * $$ Space Complexity: O(nums.length)
 */

public class Solution1 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                int index = st.pop();
                res[index] = nums[i];
            }
            st.push(i);
        }

        // circular
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                int index = st.pop();
                res[index] = nums[i];
            }
        }
        return res;
    }
}
