package BestTimeToBuyAndSellStockIV;

import java.util.Arrays;

/**
 * Assume n is prices.length.
 * Time Complexity: O(n * min(k, prices.length / 2))
 * Space Complexity: O(min(k, prices.length / 2))
 * Runtime: 187ms
 * Rank: 8.39%
 */
public class Solution1 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        k = Math.min(k, prices.length / 2);
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
