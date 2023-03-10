package BurstBalloons_312;

/**
 * Assume nums.length is n.
 * Time Complexity: O(n ^ 3)
 * Space Complexity: O(n ^ 2)
 * Runtime: 56ms
 * Rank: 77.77%
 */
class Solution1 {
    public int maxCoins(int[] nums) {
        // Important constraint:
        // 1. 1 <= nums.length <= 300 (input always valid)
        // 2. 0 <= nums[i] <= 100 (no value overflow)
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int len = 0; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                for (int k = i; k <= j; k++) {
                    int sum = 0;
                    sum += i <= k - 1 ? dp[i][k-1] : 0;
                    sum += k + 1 <= j ? dp[k+1][j] : 0;
                    int left = i - 1 >= 0 ? nums[i - 1]:1;
                    int right = j + 1 < n ?nums[j + 1]: 1;
                    sum += left * nums[k] * right;
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }
        return dp[0][n-1];
    }
}
