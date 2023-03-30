package FindMinimumInRotatedSortedArray_153;

/**
 * $$ Assume nums.length is n.
 * $$ Time Complexity: O(logn)
 * $$ Space Complexity: O(1)
 */

public class Solution1 {
    public int findMin(int[] nums) {
        int res = nums[0];
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int mid = (s+e)/2;
            res = Math.min(res, nums[s]);
            res = Math.min(res, nums[mid]);
            if (nums[s] < nums[mid]) {
                s = mid+1;
            } else if (nums[s] > nums[mid]) {
                e=mid-1;
            } else {
                s++;
            }
        }
        return res;
    }
}