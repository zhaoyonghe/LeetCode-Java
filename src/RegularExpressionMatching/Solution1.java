package RegularExpressionMatching;

/**
 * Time Complexity: O(slen * plen)
 * Space Complexity: O(slen * plen)
 * Runtime: 2ms
 * Rank: 91.37%
 */
public class Solution1 {
    public boolean isMatch(String s, String p) {
        // Important constraint:
        // 1. 1 <= s.length <= 20, 1 <= p.length <= 30 (memory not used too much)
        // 2. s contains only lowercase English letters.
        //    p contains only lowercase English letters, '.', and '*'.
        //    It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
        //    (input is always valid)
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        int m = sc.length;
        int n = pc.length;
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int j = 2; j < n; j += 2) {
            dp[0][j] = dp[0][j - 2] && pc[j - 1] == '*';
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (pc[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                if (pc[j - 1] == '*') {
                    // Match 0, 1 or > 1 pc[j - 2].
                    dp[i][j] = dp[i][j - 2] || (match(pc[j - 2], sc[i - 1]) && (dp[i][j - 1] || dp[i - 1][j]));
                    continue;
                }
                dp[i][j] = match(pc[j - 1], sc[i - 1]) && dp[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }

    private boolean match(char a, char b) {
        return a == b || a == '.' || b == '.';
    }
}
