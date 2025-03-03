package M.MaximumGap_164;

import java.util.Arrays;

/**
 * $$ Time Complexity: O(nums.length)
 * $$ Space Complexity: O(nums.length)
 */
public class Solution1 {
    // radix sort
    public int maximumGap(int[] nums) {
        int[] pos = new int[16];
        int[] buffer = new int[nums.length];
        int[] tmp = null;
        for (int j = 0; j < 8; j++) {
            Arrays.fill(pos, 0);
            for (int n : nums) {
                int d = (n >> (j << 2)) & 0xf;
                pos[d]++;
            }
            for (int i = 1; i < 16; i++) {
                pos[i] += pos[i - 1];
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                int n = nums[i];
                int d = (n >> (j << 2)) & 0xf;
                pos[d]--;
                buffer[pos[d]] = n;
            }
            tmp = nums;
            nums = buffer;
            buffer = tmp;
        }
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }
}