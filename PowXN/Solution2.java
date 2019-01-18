package PowXN;

import java.util.HashMap;
/**
 * Time Complexity: O(logn)
 * Space Complexity: O(logn)
 * Runtime: 14ms
 * Rank: 81.44%
 */
public class Solution2 {
	public HashMap<Integer, Double> map = new HashMap<>();

	public double myPow(double x, int n) {
		if (n < 0) {
			switch (n) {
			case 0:
				return 1;
			case -1:
				return 1 / x;
			case -2:
				return 1 / (x * x);
			}
		} else {
			switch (n) {
			case 0:
				return 1;
			case 1:
				return x;
			case 2:
				return x * x;
			}
		}
		if (map.containsKey(n)) {
			return map.get(n);
		} else {
			double temp = myPow(x, n >> 1);
			map.put(n >> 1, temp);
			if ((n & 1) == 0) {
				return temp * temp;
			} else {
				return temp * temp * x;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
