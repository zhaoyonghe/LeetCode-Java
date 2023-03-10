package ReverseBits;

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 100.00%
 */
public class Solution1 {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (((1 << i) & n) != 0) {
                result |= (1 << (31 - i));
            }
        }
        return result;
    }

}
