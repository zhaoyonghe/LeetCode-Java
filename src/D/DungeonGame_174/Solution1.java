package D.DungeonGame_174;

/**
 * Time Complexity: O(m * n)
 * Space Complexity: O(n)
 * Runtime: 1ms
 * Rank: 93.27%
 */

public class Solution1 {
    // Important constraints:
    // 1. m == dungeon.length
    // 2. n == dungeon[i].length
    // 3. 1 <= m, n <= 200
    // 4. -1000 <= dungeon[i][j] <= 1000
    // (never overflow)
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[] dp = new int[n];

        dp[n - 1] = 1;
        for (int j = n - 2; j >= 0; j--) {
            dp[j] = Math.max(1, dp[j + 1] - dungeon[m - 1][j + 1]);
        }

        for (int i = m - 2; i >= 0; i--) {
            dp[n - 1] = Math.max(1, dp[n - 1] - dungeon[i + 1][n - 1]);
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = Math.max(1, Math.min(dp[j] - dungeon[i + 1][j], dp[j + 1] - dungeon[i][j + 1]));
            }
        }

        return Math.max(1, dp[0] - dungeon[0][0]);
    }
}
