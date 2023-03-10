package MinimumDifficultyOfAJobSchedule_1335;
/**
 * Assume n is jobDifficulty.length.
 * Time Complexity: O(n * d)
 * Space Complexity: O(n * d)
 * Runtime: 24ms
 * Rank: 26.47%
 */
public class Solution1 {
    // Important constraints:
    // 1. 1 <= jobDifficulty.length <= 300
    //    0 <= jobDifficulty[i] <= 1000
    //    1 <= d <= 10 (input is valid; result will never overflow)
    public int minDifficulty(int[] jobDifficulty, int d) {
        dp = new Integer[jobDifficulty.length][d + 1];
        int res = helper(jobDifficulty, 0, d);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private Integer[][] dp;

    private int helper(int[] jobDifficulty, int s, int dl) {
        int n = jobDifficulty.length;
        if (s == n && dl == 0) {
            return 0;
        }
        if (s == n || dl == 0 || n - s < dl) {
            // dl more days || day exhausted || too many days
            return Integer.MAX_VALUE;
        }
        if (dp[s][dl] != null) {
            return dp[s][dl];
        }

        int todayMax = 0;
        for (int i = s; i < n; i++) {
            todayMax = Math.max(todayMax, jobDifficulty[i]);
            int val = helper(jobDifficulty, i + 1, dl - 1);
            if (val == Integer.MAX_VALUE) {
                if (dp[s][dl] == null) {
                    dp[s][dl] = Integer.MAX_VALUE;
                }
                continue;
            }
            // val != Integer.MAX_VALUE
            if (dp[s][dl] == null) {
                dp[s][dl] = todayMax + val;
                continue;
            }
            dp[s][dl] = Math.min(dp[s][dl], todayMax + val);
        }
        return dp[s][dl];
    }
}