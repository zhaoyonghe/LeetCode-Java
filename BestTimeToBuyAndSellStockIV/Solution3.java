package BestTimeToBuyAndSellStockIV;

import java.util.Arrays;

/**
 * Assume n is prices.length.
 * Time Complexity: O(n)/O(n * k)
 * Space Complexity: O(1)/O(n)
 * Runtime: 6ms
 * Rank: 94.57%
 */
class Solution3 {
	public int maxProfit(int k, int[] prices) {
		if (prices.length < 2) {
			return 0;
		}

		if (k >= prices.length / 2) {
			int sum = 0;
			for (int i = 0; i < prices.length - 1; i++) {
				if (prices[i] < prices[i + 1]) {
					sum += (prices[i + 1] - prices[i]);
				}
			}
			return sum;
		} else {
			int trans = k + 1;
			int days = prices.length;

			int[] hold0 = new int[days];
			int[] hold1 = new int[days];

			int[] unhold0 = new int[days];
			int[] unhold1 = new int[days];

			hold0[0] = -prices[0];
			hold1[0] = -prices[0];
			for (int day = 1; day < days; day++) {
				hold0[day] = Math.max(hold0[day - 1], -prices[day]);
			}

			for (int tran = 1; tran < trans; tran++) {
				for (int day = 1; day < days; day++) {
					hold1[day] = Math.max(hold1[day - 1], unhold1[day - 1] - prices[day]);
					unhold1[day] = Math.max(unhold1[day - 1], hold0[day - 1] + prices[day]);
				}

				if (unhold0[days - 1] == unhold1[days - 1]) {
					return unhold0[days - 1];
				}

				hold0 = hold1;
				hold1 = new int[days];
				hold1[0] = -prices[0];
				unhold0 = unhold1;
				unhold1 = new int[days];
			}

			return unhold0[days - 1];
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[5];
		a[0] = 3;
		a[1] = 2;
		a[2] = 4;
		int[] b = a;
		b[0] = 10;
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}
}