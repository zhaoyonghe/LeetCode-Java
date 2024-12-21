package W.WordBreakI;

import java.util.HashSet;
import java.util.List;

/**
 * Assume s.length() is n.
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(n)
 * Runtime: 15ms
 * Rank: 55.53%
 */
public class Solution1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<String>(wordDict), 0, new Boolean[s.length()]);
    }

    public boolean wordBreak(String s, HashSet<String> wordSet, int start, Boolean[] dp) {
        if (start == dp.length) {
            return true;
        }
        if (dp[start] != null) {
            return dp[start];
        }
        for (int end = start + 1; end <= dp.length; end++) {
            if (wordSet.contains(s.substring(start, end)) && wordBreak(s, wordSet, end, dp)) {
                dp[start] = true;
                return true;
            }
        }
        dp[start] = false;
        return false;
    }
}
