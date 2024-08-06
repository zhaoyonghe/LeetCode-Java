package LongestPalindromicSubstring_5;

/**
 * $$ Assume n is the length of s.
 * $$ Time Complexity: O(n^2)
 * $$ Space Complexity: O(n^2)
 */
public class Solution1 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        char[] cs = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        int resi = 0;
        int resj = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = cs[i] == cs[i + 1];
            if (dp[i][i + 1]) {
                resi = i;
                resj = i + 1;
            }
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = cs[i] == cs[j] && dp[i + 1][j - 1];
                if (dp[i][j]) {
                    resi = i;
                    resj = j;
                }
            }
        }
        return s.substring(resi, resj + 1);
    }
}
