package ClimbingStairs_70;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
    // Important constraints:
    // 1. 1 <= n <= 45 (never overflow).
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int tmp = 0;
        for (int i = 3; i <= n; i++) {
            tmp = b;
            b += a;
            a = tmp;
        }
        return b;
    }
}
