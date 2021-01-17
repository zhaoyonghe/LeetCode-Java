package CoinChangeI;

import java.util.Arrays;

/**
 * Best Time Complexity: O(amount * coins.length)
 * Space Complexity: O(amount)
 * Runtime: 11ms
 * Rank: 92.83%
 */
public class Solution3 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.sort(coins);
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
            // System.out.println(Arrays.toString(dp));
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
