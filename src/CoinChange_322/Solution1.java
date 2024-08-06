package CoinChange_322;

import java.util.Arrays;

/**
 * $$ Time Complexity: O(amount * coins.length)
 * $$ Space Complexity: O(amount)
 */
public class Solution1 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int c : coins) {
            for (int i = 0; i <= amount - c; i++) {
                if (dp[i] >= 0) {
                    dp[i + c] = dp[i + c] == -1 ? dp[i] + 1 : Math.min(dp[i + c], dp[i] + 1);
                }
            }
        }

        return dp[amount];
    }
}
