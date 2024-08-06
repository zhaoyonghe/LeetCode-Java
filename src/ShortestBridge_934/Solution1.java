package ShortestBridge_934;
/**
 * Time Complexity: O(m * n)
 * Auxiliary Space Complexity: O(m * n)
 * Runtime: 7ms
 * Rank: 63.03%
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1 {

    static private final int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public int shortestBridge(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();
        findAnIsland(grid, q);

        int count = 0;
        while (q.size() > 0) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] cur = q.poll();
                for (int[] dir : directions) {
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];
                    if (!inBound(grid, r, c) || grid[r][c] == 2 || grid[r][c] == 3) {
                        continue;
                    }
                    if (grid[r][c] == 0) {
                        grid[r][c] = 3;
                        q.offer(new int[]{r, c});
                        continue;
                    }
                    // grid[r][c] == 1
                    return count;
                }
            }
            count++;
        }
        return -1;
    }

    private boolean inBound(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    private void findAnIsland(int[][] grid, Deque<int[]> q) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                dfs(grid, i, j, q);
                return;
            }
        }
    }

    private void dfs(int[][] grid, int i, int j, Deque<int[]> q) {
        if (!inBound(grid, i, j) || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 2;
        q.offer(new int[]{i, j});
        dfs(grid, i - 1, j, q);
        dfs(grid, i + 1, j, q);
        dfs(grid, i, j - 1, q);
        dfs(grid, i, j + 1, q);
    }
}