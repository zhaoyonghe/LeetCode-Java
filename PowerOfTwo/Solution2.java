package PowerOfTwo;

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 100.00%
 */
public class Solution2 {
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) {
                return false;
            }
            return (n & (n - 1)) == 0;
        }
    }
}
