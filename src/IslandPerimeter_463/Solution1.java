package IslandPerimeter_463;

/**
 * Time Complexity: O(m * n)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 5ms
 * Rank: 99.50%
 */

public class Solution1 {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                if (i == 0 || grid[i-1][j] == 0) {
                    res++;
                }
                if (i == grid.length - 1 || grid[i+1][j] == 0) {
                    res++;
                }
                if (j == 0 || grid[i][j-1] == 0) {
                    res++;
                }
                if (j == grid[0].length - 1 || grid[i][j+1] == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}