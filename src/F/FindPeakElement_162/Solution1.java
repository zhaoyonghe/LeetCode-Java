package F.FindPeakElement_162;

/**
 * Assume n is nums.length.
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
    // Important constraints:
    // 1. nums[i] != nums[i + 1] for all valid i (never get misdirected by flat area).
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int s = 0;
        int e = n - 1;
        while (s <= e) {
            int m = (s + e) / 2;
            boolean leftSmall = m == 0 || nums[m - 1] < nums[m];
            boolean rightSmall = m == n - 1 || nums[m] > nums[m + 1];
            if (leftSmall && rightSmall) {
                return m;
            }
            if (!leftSmall && rightSmall) {
                // Slope goes down.
                e = m - 1;
                continue;
            }
            // Slope goes up or valley.
            s = m + 1;
        }
        return -1;
    }
}
