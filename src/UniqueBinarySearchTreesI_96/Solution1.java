package UniqueBinarySearchTreesI_96;

/**
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(n)
 * Runtime: 0ms
 * Rank: 100.00%
 */

class Solution1 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int l = 0, r = i - 1;
            while (l < r) {
                dp[i] += (dp[l] * dp[r]);
                l++;
                r--;
            }
            dp[i] *= 2;
            if (i % 2 != 0) {
                dp[i] += (dp[l] * dp[r]);
            }
        }
        return dp[n];
    }
}