package SearchInRotatedSortedArrayI;

/**
 * Assume n is nums.length
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 * Runtime: 8ms
 * Rank: 95.67%
 */
public class Solution3 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        if (nums[0] < target) {
            int start = 1;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[mid] <= nums[0]) {
                    end = mid - 1;
                } else {
                    // nums[mid] > nums[0]
                    if (nums[mid] > target) {
                        end = mid - 1;
                    } else if (nums[mid] < target) {
                        start = mid + 1;
                    } else {
                        return mid;
                    }
                }
            }
            return -1;
        } else if (nums[0] > target) {
            int start = 1;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[0] <= nums[mid]) {
                    start = mid + 1;
                } else {
                    if (nums[mid] > target) {
                        end = mid - 1;
                    } else if (nums[mid] < target) {
                        start = mid + 1;
                    } else {
                        return mid;
                    }
                }
            }
            return -1;
        } else {
            return 0;
        }
    }
}
