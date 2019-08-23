package JumpGameII;

import java.util.Arrays;
/**
 * Assume nums.length is n.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 7ms
 * Rank: 24.05%
 */
public class Solution1 {
	public int jump(int[] nums) {
		int[] jumpTimes = new int[nums.length];
		Arrays.fill(jumpTimes, Integer.MAX_VALUE);

		jumpTimes[0] = 0;
		int frontier = 0;

		for (int i = 0; i < nums.length; i++) {
			if (i + nums[i] <= frontier) {
				continue;
			}
			// normalize the step 
			if (nums[i] > nums.length - i - 1) {
				nums[i] = nums.length - i - 1;
			}
			// extend the frontier
			for (int j = frontier - i; j <= nums[i]; j++) {
				jumpTimes[i + j] = Math.min(jumpTimes[i + j], jumpTimes[i] + 1);
			}
			frontier = i + nums[i];
		}

		return jumpTimes[nums.length - 1];
	}
}
