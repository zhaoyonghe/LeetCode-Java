package SearchInRotatedSortedArrayI;

/**
 * Assume n is nums.length
 * Time Complexity: O(n)
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
        // From start1 to end1 and from start2 to end2, there are two ascending sub-array.
        // start1 must be 0, end2 must be nums.length - 1 and end1 + 1 = start2
        int start1 = 0;
        int end1 = nums.length - 1;
        int start2 = nums.length - 1;
        int end2 = nums.length - 1;
        // A pure ascending array is also a rotated array and can be "binary searched".
        // If change is false after the loop, this array is a pure ascending array.
        // If change is true after the loop, this array is not a pure ascending array.
        // The "break point" will be found after this loop.
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
                // target is in the second half.
                return binarySearch(nums, start2, end2, target);
            } else {
                // target is in the first half.
                return binarySearch(nums, start1, end1, target);
            }
        } else {
            return binarySearch(nums, start1, end1, target);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {4, 5, 6, 7, 0, 1, 2};
        search(a, 0);
    }

}
