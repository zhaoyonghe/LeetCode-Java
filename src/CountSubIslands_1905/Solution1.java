package CountSubIslands_1905;

/**
 * $$ Assume grid is m * n matrix.
 * $$ Time Complexity: O(m * n)
 * $$ Space Complexity: O(m * n)
 */

public class Solution1 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (grid2[i][j] == 0) {
                    continue;
                }
                if (dfs(grid1, grid2, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || i >= grid2.length || j < 0 || j >= grid2[i].length || grid2[i][j] == 0) {
            return true;
        }
        grid2[i][j] = 0;
        boolean cur = false;
        if (grid1[i][j] == 1) {
            // grid2[i][j] overlaps with a block in grid1.
            cur = true;
        }
        boolean a = dfs(grid1, grid2, i + 1, j);
        boolean b = dfs(grid1, grid2, i - 1, j);
        boolean c = dfs(grid1, grid2, i, j + 1);
        boolean d = dfs(grid1, grid2, i, j - 1);
        return a && b && c && d && cur;
    }
}