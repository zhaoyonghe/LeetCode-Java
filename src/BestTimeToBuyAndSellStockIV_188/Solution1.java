package BestTimeToBuyAndSellStockIV_188;

/**
 * Assume n is prices.length.
 * Time Complexity: O(n * min(k, prices.length / 2))
 * Space Complexity: O(n)
 * Runtime: 3ms
 * Rank: 90.55%
 */
public class Solution1 {
    public int maxProfit(int k, int[] prices) {
        // Same as BestTimeToBuyAndSellStockIII_123/Solution3.
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        int res = 0;

        for (int tran = 0; tran < k; tran++) {
            int init = 2*tran;
            if (init >= n) {
                return res;
            }
            if (init > 0) {
                buy[init]=sell[init-1]-prices[init];
            } else {
                buy[init]=-prices[init];
            }
            for (int i = init+1; i < n; i++) {
                buy[i] = Math.max(buy[i-1],sell[i-1]-prices[i]);
            }
            for (int i = init+1; i < n; i++) {
                sell[i] = Math.max(sell[i-1],buy[i-1]+prices[i]);
            }
            res = Math.max(res,sell[n-1]);
        }

        return res;
    }
}
