package RegularExpressionMatching;
/**
 * Time Complexity: O(slen * plen)
 * Space Complexity: O(slen * plen)
 * Runtime: 18ms
 * Rank: 97.60%
 */
public class Solution1 {
	public boolean isMatch(String s, String p) {
		int slen = s.length() + 1;
		int plen = p.length() + 1;
		boolean[][] dp = new boolean[slen][plen];
		dp[0][0] = true;
		// Deal with the condition that pattern can match "",
		// such as a*, a*b*
		for (int j = 2; j < plen; j++) {
			if (p.charAt(j - 1) == '*') {
				dp[0][j] = dp[0][j - 2];
			}
		}
		//
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
					dp[i][j] = false;
				}
			}
		}
		return dp[slen - 1][plen - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
