package F.FactorialTrailingZeroes;

/**
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 99.33%
 */
public class Solution1 {
    public int trailingZeroes(int n) {
        int temp = n / 5;
        if (temp == 0) {
            return 0;
        }
        return temp + trailingZeroes(temp);
    }
}
