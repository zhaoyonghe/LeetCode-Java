package WildcardMatching;

/**
 * Assume sn is s.length(0 and pn is s.length().
 * Time Complexity: O(sn * pn)
 * Space Complexity: O(sn * pn)
 * Runtime: 22ms
 * Rank: 81.55%
 */

class Solution1 {
    public boolean isMatch(String s, String p) {
        int sn = s.length();
        int pn = p.length();

        boolean[][] dp = new boolean[pn + 1][sn + 1];

        dp[0][0] = true;

        for (int i = 1; i <= pn; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[i][0] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= pn; i++) {
            for (int j = 1; j <= sn; j++) {
                if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (p.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (p.charAt(i - 1) == s.charAt(j - 1));
                }
            }
        }

        return dp[pn][sn];
    }
}
