package CoinChangeI;

import java.util.Arrays;

/**
 * Best Time Complexity: O(amount * coins.length)
 * Worse Time Complexity: O(amount * coins.length * coins.length)
 * Space Complexity: O(amount * coins.length)
 * Runtime: 79ms
 * Rank: 6.56%
 */
public class Solution1 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int m = coins.length + 1;
        int n = amount - coins[0] + 1;
        if (n <= 0) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }

        // Dynamic programming table that records best ways
        // to allocate coins for total amount of
        // coins[0], coins[0] + 1, ... , amount.
        int[][] dp = new int[m][n];

        // for example 
        // if coins = [1, 2, 5] and amount = 11
        // dp:
        // =================================
        //      1 2 3 4 5 6 7 8 9 10 11
        // =================================
        //  1
        //  2
        //  5
        // num
        // =================================

        // initialize the last row to -1
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = -1;
        }

        // initialize the "one-coin" column
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] - coins[0] < n) {
                dp[i][coins[i] - coins[0]] = 1;
                dp[m - 1][coins[i] - coins[0]] = 1;
            }
        }

        // dp[][x] can be inferred by dp[][y]s.
        // x - y can be find in coins.
        for (int i = 1; i < n; i++) {
            for (int k = 0; k < coins.length; k++) {
                if (i - coins[k] >= 0) {
                    // have a sub problem
                    if (dp[m - 1][i - coins[k]] != -1) {
                        // can be inferred
                        if (dp[m - 1][i] == -1 || dp[m - 1][i - coins[k]] + 1 < dp[m - 1][i]) {
                            // find a better way
                            // update
                            for (int j = 0; j < m - 1; j++) {
                                dp[j][i] = dp[j][i - coins[k]];
                            }
                            dp[k][i] += 1;
                            dp[m - 1][i] = dp[m - 1][i - coins[k]] + 1;
                        }
                    }
                }
            }

        }

        return dp[m - 1][n - 1];
    }
}
