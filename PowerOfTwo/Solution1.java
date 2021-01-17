package PowerOfTwo;

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 100.00%
 */
public class Solution1 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while ((n & 1) == 0) {
            n >>= 1;
        }
        if ((n >> 1) == 0) {
            return true;
        } else {
            return false;
        }
    }
}
