package B.BestTimeToBuyAndSellStockWithTransactionFee;

/**
 * Assume n is prices.length.
 * Time Complexity: O(n * k)
 * Space Complexity: O(n)
 * Runtime: 17ms
 * Rank: 37.71%
 */
class Solution1 {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 2) {
            return 0;
        }

        int k = prices.length / 2;

        int trans = k + 1;
        int days = prices.length;

        int[] hold = new int[days];

        int[] unhold = new int[days];

        hold[0] = -prices[0];
        for (int day = 1; day < days; day++) {
            hold[day] = Math.max(hold[day - 1], -prices[day]);
        }

        for (int tran = 1; tran < trans; tran++) {
            int lastResult = unhold[days - 1];
            for (int day = 1; day < days; day++) {
                unhold[day] = Math.max(unhold[day - 1], hold[day - 1] + prices[day] - fee);
                hold[day] = Math.max(hold[day - 1], unhold[day - 1] - prices[day]);
            }

            if (unhold[days - 1] == lastResult) {
                return lastResult;
            }
        }

        return unhold[days - 1];
    }
}