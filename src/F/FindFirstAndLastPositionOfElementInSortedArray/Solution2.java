package F.FindFirstAndLastPositionOfElementInSortedArray;

/**
 * Assume n is nums.length.
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 * Runtime: 4ms
 * Rank: 100.00%
 */
public class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                // nums[mid] == target
                if (mid == 0 || nums[mid - 1] != target) {
                    result[0] = mid;
                    break;
                } else {
                    end = mid - 1;
                }
            }
        }
        if (result[0] == -1) {
            return result;
        }
        start = result[0];
        end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                // nums[mid] == target
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    result[1] = mid;
                    break;
                } else {
                    start = mid + 1;
                }
            }
        }
        return result;
    }
}
