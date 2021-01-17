package HammingDistance;

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * Runtime: 7ms
 * Rank: 92.88%
 */
public class Solution1 {
    // The Hamming distance between two integers is 
    // the number of positions at which the corresponding bits are different.
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
