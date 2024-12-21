package M.MoveZeroes_283;

/**
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                continue;
            }
            swap(nums, i, j);
            i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
