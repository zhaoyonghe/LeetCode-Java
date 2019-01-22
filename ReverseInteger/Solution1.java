package ReverseInteger;
/**
 * Time Complexity: O(log10(x))
 * Space Complexity: O(log10(x))
 * Runtime: 20ms
 * Rank: 97.88%
 */
public class Solution1 {
	// MAX = 2147483647
	// MIN = -2147483648
	static int[] pow = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };

	static public int reverse(int x) {
		int sign = 1;
		if (x < 0) {
			sign = -1;
			x = x * sign;
		}
		
		// Convert x to reverse string version.
		// For example, 12345 -> "54321"
		StringBuffer sb = new StringBuffer();
		int temp = x;
		while (temp > 0) {
			sb.append((char) (temp % 10 + 48));
			temp /= 10;
		}
		
		String rev = sb.toString();
		int result = 0;
		int len = rev.length();

		// check overflow
		if ((rev.length() == 10 && sign == 1 && "2147483647".compareTo(rev) < 0)
				|| (rev.length() == 10 && sign == -1 && "2147483648".compareTo(rev) < 0)) {
			return 0;
		}
		// pass the check, this number is not overflow
		for (int i = 0; i < len; i++) {
			result += (rev.charAt(i) - 48) * pow[len - 1 - i];
		}

		return sign * result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Solution1.reverse(1534236469));
	}

}
