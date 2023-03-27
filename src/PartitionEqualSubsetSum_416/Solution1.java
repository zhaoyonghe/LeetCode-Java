package PartitionEqualSubsetSum_416;

import java.util.Arrays;

/**
 * $$ Time Complexity: O(nums.length * sum(nums))
 * $$ Space Complexity: O(sum(nums))
 */
public class Solution1 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        // 1 <= nums[i] <= 100
        boolean[] dp = new boolean[sum/2+1];
        dp[0] = true;
        for (int n : nums) {
            for (int i = dp.length - n - 1; i >= 0; i--) {
                dp[i+n] = dp[i] || dp[i+n];
            }
            if (dp[dp.length-1]) {
                return true;
            }
        }

        return false;
    }
}
