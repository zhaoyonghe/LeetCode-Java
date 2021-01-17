package CoinChangeI;

/**
 * Best Time Complexity: O(amount * coins.length)
 * Space Complexity: O(amount)
 * Runtime: 19ms
 * Rank: 91.59%
 */
public class Solution2 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // initialize
        for (int i = 1; i < dp.length; i++) {
            dp[i] = -1;
        }

        // update
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    if (dp[i - coin] != -1) {
                        if (dp[i] == -1) {
                            dp[i] = dp[i - coin] + 1;
                        } else {
                            dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                        }
                    }
                }
            }
        }

        return dp[amount];

    }
}
