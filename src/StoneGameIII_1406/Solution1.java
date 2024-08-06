package StoneGameIII_1406;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 4ms
 * Rank: 98.22%
 */

public class Solution1 {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        dp[n - 1] = stoneValue[n - 1];
        if (n == 1) {
            return getResult(dp[n - 1]);
        }
        dp[n - 2] = Math.max(stoneValue[n - 2] + stoneValue[n - 1], stoneValue[n - 2] - stoneValue[n - 1]);
        if (n == 2) {
            return getResult(dp[n - 2]);
        }
        for (int i = n - 3; i >= 0; i--) {
            int a = stoneValue[i] - dp[i + 1];
            int b = stoneValue[i] + stoneValue[i + 1] - dp[i + 2];
            int c = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[i + 3];
            dp[i] = Math.max(a, Math.max(b, c));
        }
        return getResult(dp[0]);
    }

    private String getResult(int diff) {
        if (diff > 0) {
            return "Alice";
        }
        if (diff < 0) {
            return "Bob";
        }
        return "Tie";
    }
}