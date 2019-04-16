package SortColors;
/**
 * Assume n is nums.length. 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 83.99%
 */
public class Solution1 {
	public void sortColors(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return;
		}
		int start = -1;
		int end = nums.length;
		while (start + 1 < end && nums[start + 1] == 0) {
			start++;
		}
		while (end - 1 > start && nums[end - 1] == 2) {
			end--;
		}
		int i = start + 1;
		while (i < end) {
			switch (nums[i]) {
			case 0:
				if (swap(nums, i, start + 1)) {
					start++;
				} else {
					start++;
					i++;
				}

				break;
			case 1:
				i++;
				break;
			case 2:
				swap(nums, i, end - 1);
				end--;
				break;
			}
		}
	}

	public boolean swap(int[] nums, int i, int j) {
		if (nums[i] == nums[j]) {
			return false;
		}
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		return true;
	}
}
