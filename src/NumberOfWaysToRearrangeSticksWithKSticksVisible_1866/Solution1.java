package NumberOfWaysToRearrangeSticksWithKSticksVisible_1866;

/**
 * $$ Time Complexity: O(n * k)
 * $$ Space Complexity: O(n * k)
 */

public class Solution1 {
    final int MOD = 1000000007;

    public int rearrangeSticks(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];
        for (int i = 1; i <= k; i++) {
            dp[i][i] = 1;
        }
        long fac = 1;
        for (int i = 2; i <= n; i++) {
            fac = twomul(fac, i - 1);
            dp[i][1] = fac;
        }
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j <= Math.min(i - 1, k); j++) {
                dp[i][j] = twosum(dp[i - 1][j - 1], twomul(i - 1, dp[i - 1][j]));
            }
        }
        return (int) dp[n][k];
    }

    private long twomul(long a, long b) {
        return ((a % MOD) * (b % MOD)) % MOD;
    }

    private long twosum(long a, long b) {
        return ((a % MOD) + (b % MOD)) % MOD;
    }
}