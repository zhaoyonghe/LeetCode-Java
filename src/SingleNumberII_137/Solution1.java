package SingleNumberII_137;

/**
 * Assume n is the length of integer array nums.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 100.00%
 */
public class Solution1 {
    public int singleNumber(int[] nums) {
        int x2 = 0;
        int x1 = 0;

        for (int n : nums) {
            // x2x1 + 1, 2-bit full adder.
            // carry = x1 & n;
            x2 ^= (x1 & n);
            x1 ^= n;
            // x2x1 %= 3.
            int mask = x1 & x2;
            x2 ^= mask;
            x1 ^= mask;
        }

        return x1;
    }
}
