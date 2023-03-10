package MoveZeroes;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 95.95%
 */
public class Solution1 {
    public void moveZeroes(int[] nums) {
        // first count the zeroes' number
        // but it is useless
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                count += 1;
            }
        }
        if (count == 0) {
            return;
        }

        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[target] = nums[i];
                target += 1;
            }
        }
        for (int i = nums.length - count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
