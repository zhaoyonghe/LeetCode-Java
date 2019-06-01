package BestTimeToBuyAndSellStockI;
/**
 * Assume n is the length of integer array prices.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 100.00%
 */
public class Solution1 {
	public int maxProfit(int[] prices) {
		int buy = 0;
		int sell = 1;
		int max = 0;
		while (sell < prices.length) {
			if (prices[sell] <= prices[buy]) {
				// loss money
				buy = sell;
				sell += 1;
			} else {
				// earn money
				max = Math.max(max, prices[sell] - prices[buy]);
				sell += 1;
			}
		}
		return max;
	}
}
