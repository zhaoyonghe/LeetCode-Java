package B.BestTimeToBuyAndSellStockII_122;

/**
 * Assume n is prices.length.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
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
