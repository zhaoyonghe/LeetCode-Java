package SearchInRotatedSortedArrayI;

/**
 * Assume n is nums.length
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 * Runtime: 10ms
 * Rank: 79.35%
 */
public class Solution2 {
    public int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int rotatedSearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return nums[start] == target ? start : -1;
        }
        int mid = start + ((end - start) >> 1);
        if (nums[mid] == target) {
            return mid;
        } else {
            if (nums[mid] >= nums[start] && nums[mid] >= nums[end]) {
                int firsthalf = binarySearch(nums, start, mid - 1, target);
                int secondhalf = rotatedSearch(nums, mid + 1, end, target);
                return firsthalf == -1 ? secondhalf : firsthalf;
            } else if (nums[mid] <= nums[start] && nums[mid] <= nums[end]) {
                int firsthalf = rotatedSearch(nums, start, mid - 1, target);
                int secondhalf = binarySearch(nums, mid + 1, end, target);
                return firsthalf == -1 ? secondhalf : firsthalf;
            } else {
                return binarySearch(nums, start, end, target);
            }
        }
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        return rotatedSearch(nums, 0, nums.length - 1, target);
    }
}
