package BestTimeToBuyAndSellStockII;
/**
 * Assume n is prices.length.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 71.63%
 */
public class Solution2 {
	public int maxProfit(int[] prices) {
		if (prices.length < 2) {
			return 0;
		}
		int i = 0;
		int valley = prices[0];
		int peak = prices[0];
		int result = 0;
		while (i < prices.length) {
			while (i + 1 < prices.length && prices[i] >= prices[i + 1]) {
				i += 1;
			}
			valley = prices[i];
			while (i + 1 < prices.length && prices[i] <= prices[i + 1]) {
				i += 1;
			}
			peak = prices[i];
			result += peak - valley;
			i += 1;
		}
		return result;
	}
}
