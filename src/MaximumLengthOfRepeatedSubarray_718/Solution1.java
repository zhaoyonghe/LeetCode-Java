package MaximumLengthOfRepeatedSubarray_718;
/**
 * Time Complexity: O(nums1.length * nums2.length)
 * Space Complexity: O(max(nums1.length, nums2.length))
 * Runtime: 32ms
 * Rank: 93.15%
 */

public class Solution1 {
    // Important constraints:
    // 1. 1 <= nums1.length, nums2.length <= 1000 (n > 0)
    public int findLength(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return findLength(nums2, nums1);
        }
        int res = 0;
        int[] dp = new int[nums1.length + 1];
        for (int k : nums2) {
            for (int i = nums1.length - 1; i >= 0; i--) {
                if (nums1[i] != k) {
                    dp[i + 1] = 0;
                    continue;
                }
                dp[i + 1] = dp[i] + 1;
                res = Math.max(res, dp[i + 1]);
            }
        }
        return res;
    }
}