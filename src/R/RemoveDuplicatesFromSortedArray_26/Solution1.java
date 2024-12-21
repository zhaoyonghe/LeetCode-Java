package R.RemoveDuplicatesFromSortedArray_26;

/**
 * $$ Assume n is nums.length.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j - 1] == nums[j]) {
                continue;
            }
            i++;
            nums[i] = nums[j];
        }
        return i + 1;
    }
}
