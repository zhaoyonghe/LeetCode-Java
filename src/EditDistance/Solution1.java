package EditDistance;

/**
 * Assume m is word1.length() and n is word2.length().
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 * Runtime: 18ms
 * Rank: 58.79%
 */

class Solution1 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = getMin(dp[i - 1][j - 1], dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                } else {
                    dp[i][j] = getMin(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[m][n];
    }

    public int getMin(int a, int b, int c) {
        a = Math.min(a, b);
        a = Math.min(a, c);
        return a;
    }
}