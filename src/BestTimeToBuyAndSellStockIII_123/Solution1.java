package BestTimeToBuyAndSellStockIII_123;

/**
 * Assume n is prices.length.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 40ms
 * Rank: 11.34%
 */

public class Solution1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // buy[i][k]: max profit on the end of day i when
        // I have already finished k trans and then done an extra buy.
        int[][] buy = new int[n][2];
        // sell[i][k]: max profit on the end of day i when
        // I have already finished k trans and then done an extra buy and sell (a new trans).
        int[][] sell = new int[n][2];
        buy[0][0] = -prices[0];
        // sell[0][0] is not applicable since we cannot do a sell on day 0.
        // Here set sell[0][0] to ensure sell[n-1][0] >= 0.
        for (int i = 1; i < n; i++) {
            buy[i][0] = Math.max(buy[i - 1][0], -prices[i]);
            sell[i][0] = Math.max(sell[i - 1][0], buy[i - 1][0] + prices[i]);
        }
        // We need at least 4 days to conduct 2 trans.
        if (n < 4) {
            return sell[n - 1][0];
        }
        buy[2][1] = sell[1][0] - prices[2];
        for (int i = 3; i < n; i++) {
            buy[i][1] = Math.max(buy[i - 1][1], sell[i - 1][0] - prices[i]);
            sell[i][1] = Math.max(sell[i - 1][1], buy[i - 1][1] + prices[i]);
        }

        return Math.max(sell[n - 1][0], sell[n - 1][1]);
    }
}
