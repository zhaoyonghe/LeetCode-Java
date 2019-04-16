package FindPeakElement;
/**
 * Assume n is nums.length. 
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 97.44%
 */
public class Solution1 {
	public int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return 0;
		}
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) >> 1;
			if (valueOf(nums, mid - 1) <= nums[mid] && nums[mid] <= valueOf(nums, mid + 1)) {
				// ascend
				low = mid + 1;
			} else if (valueOf(nums, mid - 1) >= nums[mid] && nums[mid] >= valueOf(nums, mid + 1)) {
				// descend
				high = mid - 1;
			} else if (valueOf(nums, mid - 1) >= nums[mid] && nums[mid] <= valueOf(nums, mid + 1)) {
				// valley
				high = mid - 1;
			} else {
				// peak
				return mid;
			}
		}
		return -1;
	}

	public int valueOf(int[] nums, int i) {
		if (i == -1 || i == nums.length) {
			return Integer.MIN_VALUE;
		}
		return nums[i];
	}
}
