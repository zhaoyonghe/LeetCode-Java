package LongestIncreasingSubsequence;

/**
 * Time Complexity: O(nums.length ^ 2)
 * Space Complexity: O(nums.length)
 * Runtime: 46ms
 * Rank: 15.67%
 */

public class Solution1 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        int[] dp = new int[n];

        // dp[i] means the length of the longest subsequence that ends with nums[i]
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;

    }
}
