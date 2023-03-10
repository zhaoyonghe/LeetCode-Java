package ProductOfArrayExceptSelf_238;

/**
 * Time Complexity: O(n)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 100.00%
 */

public class Solution1 {
    // Important constraints:
    // 1. The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int a = nums[0];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = a;
            a *= nums[i];
        }
        a = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            res[i] *= a;
            a *= nums[i];
        }
        return res;
    }
}