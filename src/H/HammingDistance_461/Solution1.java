package H.HammingDistance_461;

/**
 * $$ Time Complexity: O(1)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += (temp & 1);
            temp = (temp >> 1);
        }
        return result;
    }
}
