package CoinChange_322;

import java.util.Arrays;

/**
 * Best Time Complexity: O(amount * coins.length)
 * Space Complexity: O(amount)
 * Runtime: 9ms
 * Rank: 99.979%
 */
public class Solution2 {
    // Important constraints:
    // 1. 0 <= amount <= 10^4 (amount + 1 will not overflow).

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int c: coins) {
            for (int i = c; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - c] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1: dp[amount];
    }
}
