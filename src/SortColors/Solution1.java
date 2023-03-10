package SortColors;

/**
 * Assume n is nums.length.
 * Time Complexity: O(n)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
    public void sortColors(int[] nums) {
        // Important constraint:
        // 1 <= nums.length <= 300 (input is valid)
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            switch(nums[i]) {
                case 0:
                    swap(nums, left, i);
                    left++;
                    i++;
                    break;
                case 1:
                    i++;
                    break;
                case 2:
                    swap(nums, i, right);
                    right--;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
