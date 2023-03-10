package PowXN;

/**
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
    public double myPow(double x, int n) {
        double res = 1;
        double factor = x;
        long nn = (long)n;
        if (nn < 0) {
            nn = -nn;
        }
        while (nn != 0) {
            if (nn % 2 == 1) {
                res *= factor;
            }
            factor *= factor;
            nn >>= 1;
        }
        return n > 0 ? res : 1 / res;
    }
}
