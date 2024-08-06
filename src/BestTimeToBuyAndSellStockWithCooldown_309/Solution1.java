package BestTimeToBuyAndSellStockWithCooldown_309;

/**
 * Assume n is prices.length.
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(n)
 * Runtime: 27ms
 * Rank: 8.50%
 */
class Solution1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int k = n / 2;

        int[] unhold = new int[n];
        int[] hold = new int[n];

        // Initialization.
        hold[0] = -prices[0];
        hold[1] = Math.max(hold[0], -prices[1]);
        int res = 0;

        for (int j = 0; j < k; j++) {
            for (int i = 2; i < n; i++) {
                hold[i] = Math.max(hold[i - 1], unhold[i - 2] - prices[i]);
            }
            for (int i = 1; i < n; i++) {
                unhold[i] = Math.max(unhold[i - 1], hold[i - 1] + prices[i]);
            }
            if (res == unhold[n - 1]) {
                return res;
            }
            // res < unhold[n-1]
            res = unhold[n - 1];
        }

        return res;
    }
}