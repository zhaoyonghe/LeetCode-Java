package CoinChange_322;

import java.util.Arrays;

/**
 * Best Time Complexity: O(amount * coins.length)
 * Space Complexity: O(amount)
 * Runtime: 27ms
 * Rank: 35.86%
 */
public class Solution1 {
    // Important constraints:
    // 1. 0 <= amount <= 10^4 (amount + 1 will not overflow).

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int c: coins) {
                if (i < c) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - c] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1: dp[amount];
    }
}
