package PartitionEqualSubsetSum;

/**
 * Time Complexity: O(nums.length * sum(nums))
 * Space Complexity: O(sum(nums))
 * Runtime: 7ms
 * Rank: 91.05%
 */
public class Solution1 {
    public boolean canPartition(int[] nums) {
        if (nums.length == 1) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) != 0) {
            // the sum is odd
            return false;
        }

        sum = sum >> 1;

        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int num : nums) {
            if (sum - num >= 0 && dp[sum - num] == 1) {
                return true;
            }
            for (int i = sum - 1; i >= num; i--) {
                // System.out.println(i - num);
                // duplicate will be removed in this way
                // because it is only based on the work done before
                if (dp[i - num] == 1) {
                    dp[i] = 1;
                }
            }
        }
        return false;
    }
}
