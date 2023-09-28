package JumpGameII_45;

/**
 * $$ Assume nums.length is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(1)
 */
public class Solution2 {
    public int jump(int[] nums) {
        int right = 0;
        int farest = 0;
        int minJumpToCur = 0;
        int cur = 0;
        while (right < nums.length - 1) {
            farest = Math.max(farest, cur + nums[cur]);
            if (cur == right) {
                right = farest;
                minJumpToCur++;
            }
            cur++;
        }
        return minJumpToCur;
    }
}
