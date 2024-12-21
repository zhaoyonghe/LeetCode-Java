package F.FirstMissingPositive_41;

/**
 * Assume n is nums.length.
 * Time Complexity: O(n)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 98.85%
 */

public class Solution1 {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] <= 0 || nums[i] > n) {
                i++;
                continue;
            }
            // Do not swap the num in correct place out.
            if (nums[i] == nums[nums[i] - 1]) {
                i++;
                continue;
            }
            swap(nums, i, nums[i] - 1);
        }
        i = 0;
        for (; i < n; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }
        return n + 1; // Also i+1.
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}