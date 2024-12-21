package N.NumberOfDistinctIslands_694;

/**
 * Time Complexity: O(m * n)
 * Auxiliary Space Complexity: O(m * n)
 * Runtime: 4ms
 * Rank: 98.99%
 */

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public int numDistinctIslands(int[][] grid) {
        Set<String> m = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                dfs(grid, i, j, sb, 'o');
                m.add(sb.toString());
            }
        }
        return m.size();
    }

    private void dfs(int[][] grid, int i, int j, StringBuilder sb, char dir) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        sb.append(dir);
        sb.append('(');
        dfs(grid, i + 1, j, sb, 'd');
        dfs(grid, i - 1, j, sb, 'u');
        dfs(grid, i, j + 1, sb, 'r');
        dfs(grid, i, j - 1, sb, 'l');
        sb.append(')');
    }
}