package PowerOfFour_342;

/**
 * $$ Time Complexity: O(1)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        // 0x55555555 is 01010101010101010101010101010101
        // num is power of 2 and 1 is on odd place
        return ((num & (num - 1)) == 0) && ((num & 0x55555555) != 0);
    }
}
