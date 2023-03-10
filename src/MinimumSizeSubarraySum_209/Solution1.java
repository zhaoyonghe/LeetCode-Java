package MinimumSizeSubarraySum_209;

/**
 * Assume nums.length is n.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 100.00%
 */

public class Solution1 {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int sum = 0;
        int n = nums.length;

        while (j < n) {
            while (j < n) {
                sum += nums[j];
                j++;
                if (sum >= s) {
                    res = Math.min(res, j - i);
                    break;
                }
            }


            while (i < j) {
                sum -= nums[i];
                i++;
                if (sum >= s) {
                    res = Math.min(res, j - i);
                    continue;
                }
                // sum < s
                break;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
