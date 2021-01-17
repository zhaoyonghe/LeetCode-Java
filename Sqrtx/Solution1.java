package Sqrtx;

/**
 * Time Complexity: O(logx)
 * Space Complexity: O(1)
 * Runtime: 26ms
 * Rank: 83.84%
 */
public class Solution1 {
    public int mySqrt(int x) {
        switch (x) {
            case 0:
                return 0;
            case 1:
            case 2:
            case 3:
                return 1;
            case 4:
            case 5:
                return 2;
            default:
                break;
        }
        int low = 1;
        int high = x / 2;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            long midSquare = (long) mid * (long) mid;
            if (midSquare > x) {
                high = mid - 1;
            } else if (midSquare < x) {
                long midSquarePlusOne = midSquare + 2 * mid + 1;
                if (midSquarePlusOne > x) {
                    return mid;
                } else if (midSquarePlusOne < x) {
                    low = mid + 1;
                } else {
                    return mid + 1;
                }
            } else {
                return mid;
            }
        }
        return -1;
    }
}
