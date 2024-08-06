package LongestContinuousIncreasingSubsequence_674;

/**
 * $$ Time Complexity: O(nums.length)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public int findLengthOfLCIS(int[] nums) {
        int res = 1;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j - 1] < nums[j]) {
                res = Math.max(res, j - i + 1);
                continue;
            }
            i = j;
        }
        return res;
    }
}
