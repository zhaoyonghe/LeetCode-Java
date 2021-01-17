package PerfectSquares;

/**
 * Time Complexity: O(n ^ 1.5)
 * Space Complexity: O(n)
 * Runtime: 41ms
 * Rank: 70.49%
 */

public class Solution1 {
    public int numSquares(int n) {
        switch (n) {
            case 1:
            case 2:
            case 3:
                return n;
            case 4:
                return 1;
            default:
                break;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 1;

        int sqrt = 2;
        int square = 9;

        for (int i = 5; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            if (square > i) {
                for (int j = sqrt; j >= 1; j--) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
                continue;
            }
            if (square == i) {
                dp[i] = 1;
                sqrt += 1;
                square += ((sqrt << 1) + 1);
            }
        }

        return dp[n];
    }
}
