package NumberOfClosedIslands_1254;

/**
 * Time Complexity: O(m * n)
 * Auxiliary Space Complexity: O(m * n)
 * Runtime: 1ms
 * Rank: 100.00%
 */

public class Solution1 {
    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                if (dfs(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] == 1) {
            return true;
        }
        grid[i][j] = 1;
        boolean d = dfs(grid,i+1,j);
        boolean u = dfs(grid,i-1,j);
        boolean r = dfs(grid,i,j+1);
        boolean l = dfs(grid,i,j-1);
        return d&&u&&r&&l;
    }
}