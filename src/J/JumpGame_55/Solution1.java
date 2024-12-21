package J.JumpGame_55;

/**
 * $$ Assume nums.length is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public boolean canJump(int[] nums) {
        int farest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= farest) {
                farest = Math.max(farest, i + nums[i]);
            }
        }
        return farest >= nums.length - 1;
    }
}
