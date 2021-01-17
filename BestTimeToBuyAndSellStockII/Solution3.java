package BestTimeToBuyAndSellStockII;

/**
 * Assume n is prices.length.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 71.63%
 */
public class Solution3 {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;

    }
}
