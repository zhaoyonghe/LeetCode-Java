package RottingOranges_994;

import java.util.*;
/**
 * $$ Assume the grid size is m * n.
 * $$ Time Complexity: O(m * n)
 * $$ Space Complexity: O(m * n)
 */
public class Solution1 {
    private int[][] dirs = new int[][]{
            {1,0},{-1,0},{0,1},{0,-1}
    };
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> q = new ArrayDeque<>();
        int total = 0;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    total++;
                }
                if (grid[i][j] != 2) {
                    continue;
                }
                visited[i][j] = true;
                count++;
                q.offer(new int[]{i, j});
            }
        }
        if (total == 0 || total == count) {
            return 0;
        }
        int time = 0;
        while (!q.isEmpty()) {
            time++;
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }
                    if (visited[x][y] || grid[x][y] == 0) {
                        continue;
                    }
                    visited[x][y] = true;
                    count++;
                    q.offer(new int[]{x, y});
                }
            }
        }
        if (count < total) {
            return -1;
        }
        return time - 1;
    }
}