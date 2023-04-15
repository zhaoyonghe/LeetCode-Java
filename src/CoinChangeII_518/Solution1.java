package CoinChangeII_518;

/**
 * $$ Time Complexity: O(coins.length * amount)
 * $$ Space Complexity: O(amount)
 */
public class Solution1 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for (int c : coins) {
            for (int i = 0; i <= amount - c; i++) {
                dp[i+c]+=dp[i];
            }
        }

        return dp[amount];
    }
}
