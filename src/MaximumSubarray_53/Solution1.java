package MaximumSubarray_53;

/**
 * $$ Time Complexity: O(nums.length)
 * $$ Auxiliary Space Complexity: O(1)
 */
public class Solution1 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
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
