package RegularExpressionMatching;
/**
 * Time Complexity: O(slen * plen)
 * Space Complexity: O(slen * plen)
 * Runtime: 18ms
 * Rank: 97.60%
 */
public class Solution1 {
	public boolean isMatch(String s, String p) {
		// dp[i][j] indicates if first i character(s) in s can match first j character(s) in p.
		int slen = s.length() + 1;
		int plen = p.length() + 1;
		boolean[][] dp = new boolean[slen][plen];
		// dp[0][0] will always be true, because pattern "" can match string "".
		dp[0][0] = true;
		// Deal with the condition that pattern can match "",
		// such as a*, a*b*.
		for (int j = 2; j < plen; j++) {
			if (p.charAt(j - 1) == '*') {
				dp[0][j] = dp[0][j - 2];
			}
		}
		// Main body.
		for (int i = 1; i < slen; i++) {
			for (int j = 1; j < plen; j++) {
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					// When * indicates 0 element.
					dp[i][j] = dp[i][j - 2];
					// When * indicates 1 or more element(s).
					if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
						dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
					}
				} else {
					// When s.charAt(i - 1) != p.charAt(j - 1) && p.charAt(j - 1) != '.' && p.charAt(j - 1) != '*',
					// it means we meet the condition that really cannot match.
					// For example: "a" and "b".
					dp[i][j] = false;
				}
			}
		}
		return dp[slen - 1][plen - 1];
	}

}
