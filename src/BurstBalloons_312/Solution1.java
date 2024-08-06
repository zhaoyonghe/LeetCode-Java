package BurstBalloons_312;

/**
 * $$ Assume nums.length is n.
 * $$ Time Complexity: O(n ^ 3)
 * $$ Space Complexity: O(n ^ 2)
 */
class Solution1 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            int le = i == 0 ? 1 : nums[i - 1];
            int ri = i == n - 1 ? 1 : nums[i + 1];
            dp[i][i] = le * nums[i] * ri;
        }

        for (int d = 1; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                int j = i + d;
                int le = i == 0 ? 1 : nums[i - 1];
                int ri = j == n - 1 ? 1 : nums[j + 1];
                int max = Math.max(le * nums[i] * ri + dp[i + 1][j], le * nums[j] * ri + dp[i][j - 1]);
                for (int k = i + 1; k <= j - 1; k++) {
                    max = Math.max(max, dp[i][k - 1] + dp[k + 1][j] + le * nums[k] * ri);
                }
                dp[i][j] = max;
            }
        }

        return dp[0][n - 1];
    }
}
