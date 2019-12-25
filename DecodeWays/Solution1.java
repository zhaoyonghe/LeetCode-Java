package DecodeWays;
/**
 * Assume s.length() is n.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 1ms
 * Rank: 99.97%
 */
public class Solution1 {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int n = s.length();

		int[] dp = new int[n + 1];

		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '0') {
				if (i == 0 || (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2')) {
					return 0;
				} else {
					dp[i + 1] = i >= 1 ? dp[i - 1] : 1;
				}
			} else {
				dp[i + 1] = dp[i];
				if (i >= 1 && (s.charAt(i - 1) == '1'
						|| (s.charAt(i - 1) == '2' && s.charAt(i) > '0' && s.charAt(i) < '7'))) {
					dp[i + 1] += dp[i - 1];
				}
			}
		}
		return dp[n];
	}
}
