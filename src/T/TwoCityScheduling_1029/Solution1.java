package T.TwoCityScheduling_1029;

/**
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(n ^ 2)
 * Runtime: 3ms
 * Rank: 41.23%
 */
public class Solution1 {
    // Important constraints:
    // 1. 1 <= aCosti, bCosti <= 1000, 2 <= costs.length <= 100 (result will not overflow).
    public int twoCitySchedCost(int[][] costs) {
        int m = costs.length;
        // costs.length is even.
        int n = m / 2;
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + costs[j - 1][1];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // preson i + j - 1 goes to A, preson i + j - 1 goes to B.
                dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j - 1][0], dp[i][j - 1] + costs[i + j - 1][1]);
            }
        }
        return dp[n][n];
    }
}