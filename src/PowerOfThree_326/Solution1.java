package PowerOfThree_326;

/**
 * $$ Time Complexity: O(1)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public boolean isPowerOfThree(int n) {
        // 1162261467 is the biggest power of three under MAX_VALUE.
        return n > 0 && 1162261467 % n == 0;
    }
}
