package PredictTheWinner_486;

/**
 * Assume n is nums.length.
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 * Runtime: 0ms
 * Rank: 100.00%
 */

public class Solution3 {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int len = 1; len < n; len++) {
            for (int s = 0; s + len < n; s++) {
                int e = s + len;
                dp[s][e] = Math.max(nums[s]-dp[s+1][e],nums[e]-dp[s][e-1]);
            }
        }
        return dp[0][n-1] >= 0;
    }
}
