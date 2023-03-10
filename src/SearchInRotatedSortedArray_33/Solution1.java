package SearchInRotatedSortedArray_33;

/**
 * Assume n is nums.length
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
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
                // the first half is ascending(sorted)
                if (nums[start] <= target && target < nums[mid]) {
                    // target may in the first half 
                    end = mid - 1;
                } else {
                    // target may in the second half
                    start = mid + 1;
                }
            } else if (nums[start] > nums[mid]) {
                // the second half is ascending(sorted)
                if (nums[mid] < target && target <= nums[end]) {
                    // target may in the second half
                    start = mid + 1;
                } else {
                    // target may in the first half
                    end = mid - 1;
                }
            } else {
                // nums[start] == nums[mid],
                // which means start == mid and nums[start] != target,
                // end - start = 0 or 1
                start = start + 1;
            }
        }
        return -1;
    }
}
