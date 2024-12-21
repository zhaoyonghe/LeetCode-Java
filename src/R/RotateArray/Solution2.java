package R.RotateArray;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 89.59%
 */
public class Solution2 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        int wing = (end - start + 1) / 2;
        for (int i = 0; i < wing; i++) {
            // swap nums[start + i] and nums[end - i]
            int temp = nums[start + i];
            nums[start + i] = nums[end - i];
            nums[end - i] = temp;
        }
    }
}
