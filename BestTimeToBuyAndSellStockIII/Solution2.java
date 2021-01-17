package BestTimeToBuyAndSellStockIII;

/**
 * Assume n is prices.length.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 4ms
 * Rank: 89.74%
 */
class Solution2 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int k = 2;

        int trans = k + 1;
        int days = prices.length;

        int[][] dp = new int[trans][days];

        for (int tran = 1; tran < trans; tran++) {
            int maxDiff = dp[tran - 1][0] - prices[0];
            for (int day = 1; day < days; day++) {
                dp[tran][day] = Math.max(dp[tran][day - 1], maxDiff + prices[day]);
                maxDiff = Math.max(maxDiff, dp[tran - 1][day] - prices[day]);
            }
        }

        return dp[trans - 1][days - 1];
    }
}