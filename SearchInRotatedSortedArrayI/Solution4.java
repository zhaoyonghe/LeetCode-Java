package SearchInRotatedSortedArrayI;
/**
 * Assume n is nums.length
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 * Runtime: 8ms
 * Rank: 95.67%
 */
public class Solution4 {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		if (nums.length == 1) {
			return nums[0] == target ? 0 : -1;
		}
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[start] < nums[mid]) {
				if (nums[start] <= target && target < nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else if (nums[start] > nums[mid]) {
				if (nums[mid] < target && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else {
				// start == mid
				// end - start = 0 or 1
				start = start + 1;
			}
		}
		return -1;
	}
}
