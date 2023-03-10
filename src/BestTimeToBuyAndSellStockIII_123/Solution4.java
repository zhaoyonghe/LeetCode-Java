package BestTimeToBuyAndSellStockIII_123;

/**
 * Assume n is prices.length.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 3ms
 * Rank: 98.98%
 */
public class Solution4 {
    public int maxProfit(int[] prices) {
        // Space optimized Solution2.
        if (prices.length < 2) {
            return 0;
        }
        // money I have after:
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
        // This algorithm can be extend to n times buy-sell combinations.
    }

}