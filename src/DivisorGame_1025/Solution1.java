package DivisorGame_1025;

/**
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(n)
 * Runtime: 5ms
 * Rank: 8.73%
 */

public class Solution1 {
    public boolean divisorGame(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[1] = false;
        for (int i = 2; i <= n; i++) {
            for (int x = 1; x <= i / 2; x++) {
                if (i % x == 0 && !dp[i - x]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}