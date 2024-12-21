package P.PerfectSquares_279;

/**
 * $$ Time Complexity: O(n ^ 1.5)
 * $$ Space Complexity: O(n)
 */

public class Solution1 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int sqrt = 1; sqrt * sqrt <= i; sqrt++) {
                int tmp = dp[i - sqrt * sqrt] + 1;
                dp[i] = dp[i] == 0 ? tmp : Math.min(dp[i], tmp);
            }
        }
        return dp[n];
    }
}
