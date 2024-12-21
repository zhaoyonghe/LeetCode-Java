package R.ReverseBits_190;

/**
 * $$ Time Complexity: O(log(n))
 * $$ Space Complexity: O(log(n))
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
