package PowXN;
/**
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 * Runtime: 21ms
 * Rank: 67.33%
 */
public class Solution3 {
	public double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		double result = 1;
		long len = (long) n;
		if (n < 0) {
			len = -len;
		}
		// an excellent idea
		while (len != 0) {
			if ((len & 1) == 1) {
				result *= x;
			}
			x *= x;
			len = len >> 1;
		}
		return n > 0 ? result : 1 / result;
	}

	public static void main(String[] args) {

	}

}
