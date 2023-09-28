package JumpGameII_45;

/**
 * $$ Assume nums.length is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    // Important constraints:
    // 1. You can assume that you can always reach the last index. (No infinite loops.)
    // 2. 1 <= nums.length <= 10 ^ 4. (Answer is valid; reduce some condition checks.)
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int steps = 1;
        int thisFrontier = 0;
        int nextFrontier = nums[0];
        while (nextFrontier < nums.length - 1) {
            steps += 1;
            int max = -1;
            for (int i = thisFrontier + 1; i <= nextFrontier; i++) {
                max = Math.max(max, i + nums[i]);
            }
            thisFrontier = nextFrontier;
            nextFrontier = max;
        }
        return steps;
    }
}
