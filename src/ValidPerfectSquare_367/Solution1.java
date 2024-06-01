package ValidPerfectSquare_367;

/**
 * $$ Time Complexity: O(log(num))
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public boolean isPerfectSquare(int num) {
        long start = 1;
        long end = num;
        while (start <= end) {
            long mid = (start + end) / 2;
            long sq = mid * mid;
            if (sq > (long) num) {
                end = mid - 1;
            } else if (sq < (long) num) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
