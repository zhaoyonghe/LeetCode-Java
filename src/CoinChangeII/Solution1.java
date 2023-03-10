package CoinChangeII;

/**
 * Time Complexity: O(coins.length * amount)
 * Space Complexity: O(amount)
 * Runtime: 2ms
 * Rank: 99.85%
 */
public class Solution1 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // use different coins in order
        // no duplication
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
