package S.StoneGameIV_1510;

/**
 * Time Complexity: O(n ^ 3/2)
 * Space Complexity: O(n)
 * Runtime: 11ms
 * Rank: 91.72%
 */
public class Solution1 {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = true;
        for (int i = 2; i <= n; i++) {
            int root = 1;
            while (true) {
                int square = root * root;
                if (square > i) {
                    break;
                }
                if (!dp[i - square]) {
                    dp[i] = true;
                    break;
                }
                root++;
            }
        }
        return dp[n];
    }
}