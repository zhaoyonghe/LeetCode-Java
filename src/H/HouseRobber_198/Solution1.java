package H.HouseRobber_198;

/**
 * $$ Assume n is nums.length.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        // dp[i] means that the max rob value if only have i + 1 houses
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }
}
