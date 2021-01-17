package HouseRobberII;


/**
 * Assume n is nums.length.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 4ms
 * Rank: 98.11%
 */
public class Solution1 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        // rob the first house or the last house or neither
        return Math.max(srob(nums, 0, len - 2), srob(nums, 1, len - 1));
    }

    // small rob
    public int srob(int[] nums, int start, int end) {
        int len = end - start + 1;

        int[] dp = new int[len];
        dp[0] = nums[start];
        dp[1] = nums[start] > nums[start + 1] ? nums[start] : nums[start + 1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

}
