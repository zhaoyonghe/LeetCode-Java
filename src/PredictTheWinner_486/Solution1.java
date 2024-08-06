package PredictTheWinner_486;

/**
 * Assume n is nums.length.
 * Time Complexity: O(2 ^ n)
 * Space Complexity: O(n)
 * Runtime: 1ms
 * Rank: 48.77%
 */

public class Solution1 {
    public boolean PredictTheWinner(int[] nums) {
        return playerAWillWin(nums, 0, nums.length - 1, 0, true);
    }

    private boolean playerAWillWin(int[] nums, int i, int j, int scoreDiff, boolean aTurn) {
        if (i > j) {
            return scoreDiff >= 0;
        }

        if (aTurn) {
            return playerAWillWin(nums, i + 1, j, scoreDiff + nums[i], false) ||
                    playerAWillWin(nums, i, j - 1, scoreDiff + nums[j], false);
        }
        return playerAWillWin(nums, i + 1, j, scoreDiff - nums[i], true) &&
                playerAWillWin(nums, i, j - 1, scoreDiff - nums[j], true);
    }
}
