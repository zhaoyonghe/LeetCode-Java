package BestTimeToBuyAndSellStockIV;

import java.util.Arrays;

/**
 * Assume n is prices.length.
 * Time Complexity: O(n)/O(n * k)
 * Space Complexity: O(1)/O(k)
 * Runtime: 4ms
 * Rank: 98.66%
 */
public class Solution2 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        k = Math.min(k, prices.length / 2);
        if (k >= prices.length / 2) {
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    max += prices[i] - prices[i - 1];
                }
            }
            return max;
        } else {
            int[] buy = new int[k + 1];
            int[] sell = new int[k + 1];
            Arrays.fill(buy, Integer.MIN_VALUE);
            for (int p : prices) {
                for (int i = 1; i <= k; i++) {
                    buy[i] = Math.max(buy[i], sell[i - 1] - p);
                    sell[i] = Math.max(sell[i], buy[i] + p);
                }
            }
            return sell[k];
        }

    }
}
