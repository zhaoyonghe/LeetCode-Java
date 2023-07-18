package SlidingWindowMaximum_239;

/**
 * $$ Assume nums.length is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */

public class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] lm = new int[n];
        int[] rm = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i % k == 0) {
                max = nums[i];
            }
            max = Math.max(max, nums[i]);
            lm[i] = max;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1 || (i + 1) % k == 0) {
                max = nums[i];
            }
            max = Math.max(max, nums[i]);
            rm[i] = max;
        }

        int[] res = new int[n - k + 1];
        for (int i = 0; i + k - 1 < n; i++) {
            res[i] = Math.max(rm[i], lm[i + k - 1]);
        }

        return res;
    }
}
