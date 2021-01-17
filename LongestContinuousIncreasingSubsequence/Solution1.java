package LongestContinuousIncreasingSubsequence;

/**
 * Time Complexity: O(nums.length)
 * Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 96.86%
 */
public class Solution1 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int maxLen = 1;

        while (i < nums.length) {
            while (j + 1 < nums.length && nums[j + 1] > nums[j]) {
                j++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            i = j + 1;
            j = i;
        }

        return maxLen;

    }
}
