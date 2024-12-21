package N.NextPermutation_31;

/**
 * Assume n is nums.length.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */

public class Solution1 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1;
        for (; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                break;
            }
        }
        if (i == 0) {
            reverse(nums, 0, n - 1);
            return;
        }
        for (int j = n - 1; j >= i; j--) {
            if (nums[i - 1] < nums[j]) {
                swap(nums, i - 1, j);
                reverse(nums, i, n - 1);
                return;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}