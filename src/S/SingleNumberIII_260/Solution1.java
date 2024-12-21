package S.SingleNumberIII_260;

/**
 * Assume n is the length of integer array nums.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 100.00%
 */

public class Solution1 {
    public int[] singleNumber(int[] nums) {
        int div = 0;
        for (int n : nums) {
            div ^= n;
        }
        int a = 0, b = 0;
        int lowestBitOne = div & ((~div) + 1);
        for (int n : nums) {
            if ((lowestBitOne & n) == 0) {
                a ^= n;
                continue;
            }
            b ^= n;
        }
        return new int[]{a, b};
    }
}
