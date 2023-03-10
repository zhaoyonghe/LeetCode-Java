package MaximumSubarray_53;

/**
 * Time Complexity: O(nums.length)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
    public int maxSubArray(int[] nums) {
        // Important constraints:
        // 1 <= nums.length <= 3 * 10^4 (input is always valid, not null)
        // -10^5 <= nums[i] <= 10^5 (sum will never overflow)
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            res = Math.max(res, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return res;
    }
}
