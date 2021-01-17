package UniqueBinarySearchTreesI;

/**
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(n)
 * Runtime: 0ms
 * Rank: 100.00%
 */

class Solution1 {
    public int numTrees(int n) {
        switch (n) {
            case 0:
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 5;
        }

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for (int m = 4; m <= n; m++) {
            int half = m / 2;
            // i is the root value
            // i - 1 is the amount of nodes in leftt subtree
            // m - i is the amount of nodes in right subtree
            int i = 1;
            for (; i <= half; i++) {
                dp[m] += (dp[i - 1] * dp[m - i]);
            }

            // symmetric calculations
            dp[m] *= 2;
            if ((m & 1) == 1) {
                // odd, i == half + 1 now
                dp[m] += (dp[i - 1] * dp[m - i]);
            }
        }

        return dp[n];
    }
}