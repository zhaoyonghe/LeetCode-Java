package JumpGameII;
/**
 * Assume nums.length is n.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 3ms
 * Rank: 95.25%
 */
public class Solution2 {
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
