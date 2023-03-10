package DominoAndTrominoTiling;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Runtime: 1ms
 * Rank: 97.67%
 */
public class Solution1 {
    public int numTilings(int N) {
        if (N <= 1) {
            return 1;
        }

        long[] dp = new long[N + 1];

        dp[0] = 1;
        dp[1] = 1;

        long sum = 2;
        for (int i = 2; i <= N; i++) {
            sum += (dp[i - 1] * 2);
            dp[i] = sum - dp[i - 1] - dp[i - 2];
            dp[i] %= 1000000007L;
        }
        return (int) (dp[N] % 1000000007L);
    }
}
