package BestTimeToBuyAndSellStockI_121;

/**
 * Assume n is the length of integer array prices.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 100.00%
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int res = 0;
        int have = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < have) {
                have = prices[i];
                continue;
            }
            res = Math.max(res, prices[i] - have);
        }
        return res;
    }
}
