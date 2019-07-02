package FindTheDuplicateNumber;

/**
 * Time Complexity: O(nums.length)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 99.64%
 */

public class Solution1 {
	public int findDuplicate(int[] nums) {
		int fast = 0;
		int slow = 0;

		do {
			fast = nums[nums[fast]];
			slow = nums[slow];
		} while (fast != slow);

		// find the entrance of the cycle
		fast = 0;
		while (fast != slow) {
			fast = nums[fast];
			slow = nums[slow];
		}

		return fast;
	}
}
