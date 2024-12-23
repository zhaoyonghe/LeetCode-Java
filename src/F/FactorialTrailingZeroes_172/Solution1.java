package F.FactorialTrailingZeroes;

/**
 * $$ Time Complexity: O(logn)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public int trailingZeroes(int n) {
        int x = 1;
        int res = 0;
        while (true) {
            int zeros = n / x / 5;
            if (zeros == 0) {
                break;
            }
            res += zeros;
            x *= 5;
        }
        return (int) res;
    }
}
