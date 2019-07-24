package WordBreakI;

import java.util.List;

/**
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(n)
 * Runtime: 1ms
 * Rank: 100.00%
 */
public class Solution2 {
	public boolean wordBreak(String s, List<String> wordDict) {
		return wordBreak(s, wordDict, 0, new Boolean[s.length()]);
	}

	public boolean wordBreak(String s, List<String> wordDict, int start, Boolean[] dp) {
		if (start == dp.length) {
			return true;
		}
		if (dp[start] != null) {
			return dp[start];
		}
		for (String str : wordDict) {
			if (s.startsWith(str, start) && wordBreak(s, wordDict, start + str.length(), dp)) {
				dp[start] = true;
				return true;
			}
		}
		dp[start] = false;
		return false;
	}
}
