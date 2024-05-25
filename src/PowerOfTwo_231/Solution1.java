package PowerOfTwo_231;

/**
 * $$ Time Complexity: O(1)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
