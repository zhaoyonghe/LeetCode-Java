package SearchInRotatedSortedArray;
/**
 * Time Complexity: O(nums.length)
 * Space Complexity: O(1)
 * Runtime: 15ms
 * Rank: 57.61%
 */
public class Solution1 {
	public static int binarySearch(int[] nums, int start, int end, int target) {
		if (nums.length == 0) {
			return -1;
		}
		if (nums.length == 1) {
			return target == nums[0] ? 0 : -1;
		}
		int mid;
		while (start <= end) {
			mid = start + ((end - start) >> 1);
			if (nums[mid] < target) {
				start = mid + 1;

			} else if (nums[mid] > target) {
				end = mid - 1;

			} else {
				return mid;
			}
		}
		return -1;
	}

	public static int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}
		if (nums.length == 1) {
			return target == nums[0] ? 0 : -1;
		}
		int start1 = 0;
		int end1 = nums.length - 1;
		int start2 = nums.length - 1;
		int end2 = nums.length - 1;
		boolean change = false;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				end1 = i;
				start2 = i + 1;
				change = true;
				break;
			}
		}
		if (change) {
			if (target < nums[start2] || target > nums[end1]) {
				return -1;
			} else if (target >= nums[start2] && target <= nums[end2]) {
				return binarySearch(nums, start2, end2, target);
			} else {
				return binarySearch(nums, start1, end1, target);
			}
		} else {
			return binarySearch(nums, start1, end1, target);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 4, 5, 6, 7, 0, 1, 2 };
		search(a, 0);
	}

}
