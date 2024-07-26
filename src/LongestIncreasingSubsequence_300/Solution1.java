package LongestIncreasingSubsequence_300;

import java.util.Arrays;

/**
 * $$ Time Complexity: O(nums.length ^ 2)
 * $$ Space Complexity: O(nums.length)
 */

public class Solution1 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (nums[i] < nums[j]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
