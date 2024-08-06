package ProductOfArrayExceptSelf_238;

import java.util.Arrays;

/**
 * $$ Assume n is nums.length.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(1)
 */

public class Solution1 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);

        int cur = 1;
        for (int i = 0; i < n - 1; i++) {
            // cur is nums[0]~nums[i]
            cur *= nums[i];
            res[i + 1] *= cur;
        }
        cur = 1;
        for (int i = n - 1; i > 0; i--) {
            // cur is nums[i]~nums[n-1]
            cur *= nums[i];
            res[i - 1] *= cur;
        }
        return res;
    }
}