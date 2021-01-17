package ValidPerfectSquare;

/**
 * Time Complexity: O(num)
 * Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
    public boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            long sq = (long) mid * (long) mid;
            if (sq > num) {
                end = mid - 1;
            } else if (sq < num) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
