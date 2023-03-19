package MaxAreaOfIsland_695;

/**
 * $$ Assume grid is m * n matrix.
 * $$ Time Complexity: O(m * n)
 * $$ Space Complexity: O(m * n)
 */

public class Solution1 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                res = Math.max(res, dfs(grid, i, j));
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int count = 1;
        grid[i][j] = 0;
        count += dfs(grid, i+1,j);
        count += dfs(grid, i-1,j);
        count += dfs(grid, i,j+1);
        count += dfs(grid, i,j-1);
        return count;
    }
}