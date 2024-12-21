package V.ValidParenthesisString_678;

/**
 * $$ Assume s.length() is n.
 * $$ Time Complexity: O(n ^ 3)
 * $$ Space Complexity: O(n ^ 2)
 */

public class Solution1 {
    public boolean checkValidString(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = s.charAt(i) == '*';
        }
        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i + 1] = paired(s.charAt(i), s.charAt(i + 1));
        }
        for (int d = 3; d <= s.length(); d++) {
            for (int i = 0; i + d - 1 < s.length(); i++) {
                int j = i + d - 1;
                if (paired(s.charAt(i), s.charAt(j)) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    continue;
                }
                for (int k = i; k < j; k++) {
                    if (dp[i][k] && dp[k + 1][j]) {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }

        return dp[0][s.length() - 1];
    }

    private boolean paired(char a, char b) {
        return (a == '(' && b == '*') || (a == '*' && b == ')') || (a == '(' && b == ')') || (a == '*' && b == '*');
    }
}