package SearchInRotatedSortedArrayII_81;

/**
 * $$ Assume nums.length is n.
 * $$ Best Time Complexity: O(logn)
 * $$ Worse Time Complexity: O(n), when almost every number in nums has same value.
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public boolean search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int mid = (s+e)/2;
            if (target == nums[s]) {
                return true;
            }
            if (target == nums[mid]) {
                return true;
            }
            if (nums[s] < nums[mid]) {
                if (nums[mid] < target) {
                    s = mid+1;
                } else if (nums[s] < target) {
                    e = mid-1;
                } else {
                    // target < nums[s]
                    s = mid+1;
                }
            } else if (nums[s] > nums[mid]){
                if (target < nums[mid]) {
                    e = mid-1;
                } else if (target < nums[s]) {
                    s = mid+1;
                } else {
                    // nums[s] < target
                    e = mid-1;
                }
            } else {
                s++;
            }
        }
        return false;
    }
}
