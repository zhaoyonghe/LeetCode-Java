package BestTimeToBuyAndSellStockII;

/**
 * Assume n is the length of integer array prices.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 3ms
 * Rank: 15.19%
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int buy = 0;
        int sell = 1;
        while (sell < prices.length) {
            for (; sell < prices.length; sell++) {
                if (sell + 1 < prices.length) {
                    if (prices[sell] < prices[buy]) {
                        buy = sell;
                        sell += 1;
                        break;
                    } else {
                        if (prices[sell] > prices[sell + 1]) {
                            max += prices[sell] - prices[buy];
                            buy = sell + 1;
                            sell += 2;
                            break;
                        }
                    }

                } else {
                    if (prices[sell] > prices[buy]) {
                        max += prices[sell] - prices[buy];
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution1 s = new Solution1();
        int[] prices = {1, 2, 3, 4, 5};
        s.maxProfit(prices);
    }

}
