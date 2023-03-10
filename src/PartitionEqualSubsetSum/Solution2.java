package PartitionEqualSubsetSum;

/**
 * Time Complexity: O(nums.length * sum(nums))
 * Space Complexity: O(sum(nums))
 * Runtime: 5ms
 * Rank: 94.11%
 */
public class Solution2 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        sum /= 2;
        boolean[] dp = new boolean[sum + 1];

        dp[0] = true;

        for (int num : nums) {
            for (int i = sum - num; i >= 0; i--) {
                dp[i + num] |= dp[i] && true;
            }
            if (dp[sum]) {
                return true;
            }
        }
        return false;
    }
}
