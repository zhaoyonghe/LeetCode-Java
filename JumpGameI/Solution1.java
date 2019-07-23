package JumpGameI;
/**
 * Assume nums.length is n.
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(n)
 * Runtime: 5ms
 * Rank: 31.33%
 */
public class Solution1 {
	public boolean canJump(int[] nums) {
		boolean[] canReach = new boolean[nums.length];
		canReach[0] = true;

		for (int i = 1; i < nums.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				// can reach j 
				// &&
				// from j can jump to i
				canReach[i] = canReach[j] && ((i - j) <= nums[j]);
				if (canReach[i]) {
					break;
				}
			}
		}

		return canReach[nums.length - 1];
	}
}
