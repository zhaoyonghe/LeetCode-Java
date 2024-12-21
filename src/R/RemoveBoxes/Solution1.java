package R.RemoveBoxes;

/**
 * Assume n is the boxes.length.
 * Time Complexity: O(n ^ 4)
 * Space Complexity: O(n ^ 3)
 * Runtime: 106ms
 * Rank: 9.23%
 */

public class Solution1 {
    private int[][][] dp;

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;

        dp = new int[n][n][n];
        return dfs(0, n - 1, 0, boxes);
    }

    private int dfs(int i, int j, int k, int[] boxes) {
        if (i > j)
            return 0;
        if (i == j)
            return (k + 1) * (k + 1);
        if (dp[i][j][k] > 0)
            return dp[i][j][k];

        dp[i][j][k] = dfs(i, j - 1, 0, boxes) + (k + 1) * (k + 1);
        for (int p = i; p < j; p++) {
            if (boxes[p] == boxes[j]) {
                dp[i][j][k] = Math.max(dp[i][j][k], dfs(i, p, k + 1, boxes) + dfs(p + 1, j - 1, 0, boxes));
            }
        }

        return dp[i][j][k];
    }
}
