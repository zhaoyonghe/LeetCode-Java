package DungeonGame_174;

/**
 * Time Complexity: O(m * n)
 * Space Complexity: O(n)
 * Runtime: 1ms
 * Rank: 93.27%
 */

public class Solution2 {
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
        dp[n-1]=Math.max(1, 1-dungeon[m-1][n-1]);
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = Math.max(1,dp[i+1]-dungeon[m-1][i]);
        }
        for (int i = m - 2; i >= 0; i--) {
            dp[n-1] = Math.max(1,dp[n-1]-dungeon[i][n-1]);
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = Math.max(1,Math.min(dp[j],dp[j+1])-dungeon[i][j]);
            }
        }
        return dp[0];
    }
}
