package BestTimeToBuyAndSellStockIII;
/**
 * Assume n is prices.length.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 3ms
 * Rank: 94.08%
 */
public class Solution1 {
	public int maxProfit(int[] prices) {
		if (prices.length < 2) {
			return 0;
		}
		int firstBuy = Integer.MIN_VALUE;
		int firstSell = 0;
		int secondBuy = Integer.MIN_VALUE;
		int secondSell = 0;
		for (int p : prices) {
			firstBuy = Math.max(firstBuy, -p);
			firstSell = Math.max(firstSell, firstBuy + p);
			secondBuy = Math.max(secondBuy, firstSell - p);
			secondSell = Math.max(secondSell, secondBuy + p);
		}
		return secondSell;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
