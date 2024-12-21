package S.StoneGame_877;

/**
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(n ^ 2)
 * Runtime: 13ms
 * Rank: 12.42%
 */

public class Solution1 {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for (int len = 1; len < n; len++) {
            for (int s = 0; s + len < n; s++) {
                int e = s + len;
                dp[s][e] = Math.max(piles[s] - dp[s + 1][e], piles[e] - dp[s][e - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }
}