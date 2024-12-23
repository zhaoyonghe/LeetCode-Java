package N.NextPermutation_31;

/**
 * $$ Assume n is nums.length.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(1)
 */

public class Solution1 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }
        int i = n - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        // nums[i+1:] is non-increasing
        if (i == -1) {
            // nums is the max permutation
            reverse(nums, 0, n - 1);
            return;
        }

        for (int j = n - 1; j >= i + 1; j--) {
            if (nums[i] < nums[j]) {
                swap(nums, i, j);
                break;
            }
        }
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}