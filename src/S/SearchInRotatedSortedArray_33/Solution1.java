package S.SearchInRotatedSortedArray_33;

/**
 * $$ Assume nums.length is n.
 * $$ Time Complexity: O(logn)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[s] == target) {
                return s;
            }
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[s] < nums[mid]) {
                if (target < nums[s]) {
                    s = mid + 1;
                } else if (target < nums[mid]) {
                    e = mid - 1;
                } else {
                    // nums[mid] < target
                    s = mid + 1;
                }
            } else if (nums[mid] < nums[s]) {
                if (target < nums[mid]) {
                    e = mid - 1;
                } else if (target < nums[s]) {
                    s = mid + 1;
                } else {
                    // nums[s] < target
                    e = mid - 1;
                }
            } else {
                // nums[mid] == nums[s]
                s++;
            }
        }
        return -1;
    }
}
