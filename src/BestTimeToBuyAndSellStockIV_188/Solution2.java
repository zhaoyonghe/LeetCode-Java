package BestTimeToBuyAndSellStockIV_188;

/**
 * Assume n is prices.length.
 * Time Complexity: O(n * min(k, prices.length / 2))
 * Space Complexity: O(n)
 * Runtime: 1ms
 * Rank: 99.81%
 */
public class Solution2 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        k = Math.min(k, n / 2);

        int[] unhold = new int[n];
        int[] hold = new int[n];

        // Initialization.
        hold[0] = -prices[0];

        for (int j = 0; j < k; j++) {
            for (int i = 1; i < n; i++) {
                hold[i] = Math.max(hold[i-1], unhold[i-1]-prices[i]);
            }
            for (int i = 1; i < n; i++) {
                unhold[i] = Math.max(unhold[i-1], hold[i-1]+prices[i]);
            }
        }

        return unhold[n-1];
    }
}
