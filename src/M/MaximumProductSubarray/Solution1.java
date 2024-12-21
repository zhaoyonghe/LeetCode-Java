package M.MaximumProductSubarray;

/**
 * Time Complexity: O(nums.length)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 100.00%
 */

public class Solution1 {
    public int maxProduct(int[] nums) {
        // if all numbers in nums are not zero
        // then the max product array must consists the first or the last element in nums
        if (nums.length == 1) {
            return nums[0];
        }

        int cursor = 0;
        int result = nums[0];
        int temp = 1;

        while (cursor < nums.length) {
            temp *= nums[cursor];
            result = Math.max(result, temp);
            cursor += 1;
            if (temp == 0) {
                temp = 1;
            }
        }

        temp = 1;
        cursor = nums.length - 1;

        while (cursor > -1) {
            temp *= nums[cursor];
            result = Math.max(result, temp);
            cursor -= 1;
            if (temp == 0) {
                temp = 1;
            }
        }

        return result;
    }
}
