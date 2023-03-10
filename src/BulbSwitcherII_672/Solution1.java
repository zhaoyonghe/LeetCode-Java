package BulbSwitcherII_672;

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
    // Important constraints:
    // 1. 1 <= n <= 1000
    // 2. 0 <= presses <= 1000
    public int flipLights(int n, int presses) {
        n = Math.min(n, 4);
        presses = Math.min(presses, 3);
        int[][] a = new int[][]{
                {0, 0, 0, 0},
                {1, 2, 2, 2},
                {1, 3, 4, 4},
                {1, 4, 7, 8},
                {1, 4, 7, 8},
        };
        return a[n][presses];
    }
}