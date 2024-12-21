package S.SlidingWindowMaximum_239;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * $$ Assume nums.length is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(k)
 */
public class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        // element: [index, value]
        Deque<int[]> mq = new ArrayDeque<>();
        for (int i = 0; i < k - 1; i++) {
            offerMonotonicQueue(mq, new int[]{i, nums[i]});
        }

        for (int i = 0; i + k <= nums.length; i++) {
            // window: i ~ i + k -1

            // Clear the number outside the window.
            // At most one number will be cleared.
            if (!mq.isEmpty() && mq.peekFirst()[0] < i) {
                mq.pollFirst();
            }

            offerMonotonicQueue(mq, new int[]{i + k - 1, nums[i + k - 1]});
            // q is not empty here
            res[i] = mq.peekFirst()[1];
        }


        return res;
    }

    private void offerMonotonicQueue(Deque<int[]> mq, int[] element) {
        while (!mq.isEmpty() && mq.peekLast()[1] <= element[1]) {
            mq.pollLast();
        }
        mq.offerLast(element);
    }
}
