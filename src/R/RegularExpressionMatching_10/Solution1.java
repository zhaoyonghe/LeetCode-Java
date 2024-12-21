package R.RegularExpressionMatching_10;

/**
 * $$ Assume s.length() is slen and p.length() is plen.
 * $$ Time Complexity: O(slen * plen)
 * $$ Space Complexity: O(slen * plen)
 */
public class Solution1 {
    public boolean isMatch(String s, String p) {
        // Important constraint:
        // 1. 1 <= s.length <= 20, 1 <= p.length <= 30 (memory not used too much)
        // 2. s contains only lowercase English letters.
        //    p contains only lowercase English letters, '.', and '*'.
        //    It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
        //    (input is always valid)
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 2; j <= p.length(); j += 2) {
            if (p.charAt(j - 1) != '*') {
                break;
            }
            dp[0][j] = true;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)));
                    continue;
                }
                dp[i][j] = dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1);
            }
        }

        return dp[s.length()][p.length()];
    }
}
