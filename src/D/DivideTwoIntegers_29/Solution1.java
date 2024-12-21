package D.DivideTwoIntegers_29;

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 100.00%
 */

public class Solution1 {
    public int divide(int dividend, int divisor) {
        long res;
        if (dividend >= 0 && divisor >= 0) {
            res = posDivide(dividend, divisor);
        } else if (dividend >= 0 && divisor < 0) {
            res = -posDivide(dividend, -(long) divisor);
        } else if (dividend < 0 && divisor >= 0) {
            res = -posDivide(-(long) dividend, divisor);
        } else {
            // dividend < 0 && divisor < 0
            res = posDivide(-(long) dividend, -(long) divisor);
        }

        return res > (long) Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
    }

    public long posDivide(long a, long b) {
        long res = 0;

        while (a >= b) {
            // System.out.printf("%d %d\n", a, b);
            for (int i = 31; i >= 0; i--) {
                if ((b << i) <= a) {
                    a -= (b << i);
                    // must add (long) here, otherwise 1 << i will be negative.
                    res += ((long) 1 << i);
                    // System.out.printf("res: %d\n", res);
                    break;
                }
            }
        }

        return res;
    }
}
