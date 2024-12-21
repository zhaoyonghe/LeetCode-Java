package B.BestTimeToBuyAndSellStockIII_123;

/**
 * Assume n is prices.length.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 6ms
 * Rank: 46.41%
 */
class Solution2 {
    public int maxProfit(int[] prices) {
        // Space optimized Solution1.
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        buy[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], -prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        if (n < 4) {
            return sell[n - 1];
        }
        int oneTransMax = sell[n - 1];
        buy[2] = sell[1] - prices[2];
        for (int i = 3; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
        }
        for (int i = 3; i < n; i++) {
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return Math.max(oneTransMax, sell[n - 1]);
    }
}