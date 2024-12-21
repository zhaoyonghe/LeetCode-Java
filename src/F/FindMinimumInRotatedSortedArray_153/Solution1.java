package F.FindMinimumInRotatedSortedArray_153;

/**
 * $$ Assume nums.length is n.
 * $$ Time Complexity: O(logn)
 * $$ Space Complexity: O(1)
 */

public class Solution1 {
    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int m = (s + e) / 2;
            if (nums[m] < nums[0]) {
                if (nums[m - 1] < nums[m]) {
                    e = m - 1;
                    continue;
                }
                return nums[m];
            } else {
                // nums[m] >= nums[0]
                s = m + 1;
            }
        }
        return -1;
    }
}