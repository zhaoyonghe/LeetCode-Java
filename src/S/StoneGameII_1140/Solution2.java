package S.StoneGameII_1140;


/**
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(n ^ 2)
 * Runtime: 2ms
 * Rank: 100.00%
 */

public class Solution2 {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] memo = new int[n][n + 1];
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        return solve(piles, 0, 1, memo, suffixSum);
    }

    private int solve(int[] piles, int i, int m, int[][] memo, int[] suffixSum) {
        if (i >= piles.length) {
            return 0;
        }
        if (piles.length <= i + 2 * m) {
            return suffixSum[i];
        }
        if (memo[i][m] > 0) {
            return memo[i][m];
        }
        int res = 0;
        for (int take = 1; take <= 2 * m; take++) {
            res = Math.max(res, suffixSum[i] - solve(piles, i + take, Math.max(m, take), memo, suffixSum));
        }
        memo[i][m] = res;
        return memo[i][m];
    }
}
