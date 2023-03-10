package PredictTheWinner_486;

/**
 * Assume n is nums.length.
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 * Runtime: 0ms
 * Rank: 100.00%
 */

public class Solution2 {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] memo = new Integer[n][n];
        return getMax(0, n - 1, nums, memo) >= 0;
    }

    private int getMax(int i, int j, int[] nums, Integer[][] memo) {
        if (i > j) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        memo[i][j] = Math.max(nums[i] - getMax(i + 1, j, nums, memo), nums[j] - getMax(i, j - 1, nums, memo));
        return memo[i][j];
    }
}
