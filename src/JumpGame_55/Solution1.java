package JumpGame_55;

/**
 * Assume nums.length is n.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 100.00%
 */
public class Solution1 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int n = nums.length;

        int i = 0;

        // the farthest frontier until now
        int j = 0;

        while (i <= j) {

            if (j < i + nums[i]) {
                // update the farthest frontier
                j = i + nums[i];
                // judge
                if (j >= n - 1) {
                    return true;
                }
            }

            i++;
        }

        return false;

    }
}
