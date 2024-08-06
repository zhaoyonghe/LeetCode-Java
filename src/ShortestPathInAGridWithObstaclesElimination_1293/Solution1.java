package ShortestPathInAGridWithObstaclesElimination_1293;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Time Complexity: O(m * n * k)
 * Space Complexity: O(m * n * k)
 * Runtime: 35ms
 * Rank: 62.00%
 */
public class Solution1 {
    // up, left, right, down
    private final int[][] dirs = new int[][]{
            {-1, 0}, {0, -1}, {0, 1}, {1, 0}
    };
    private boolean[][][] visited;

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        if (m == 1 && n == 1) {
            return 0;
        }
        visited = new boolean[m][n][k + 1];
        visited[0][0][k] = true;
        Deque<int[]> q = new ArrayDeque<>();
        // grid[0][0] == 0
        q.offer(new int[]{0, 0, k, -1});
        int cnt = 0;
        while (q.size() > 0) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    if (j + cur[3] == 3) {
                        // Do not go back.
                        continue;
                    }
                    int[] next = new int[]{cur[0] + dirs[j][0], cur[1] + dirs[j][1], cur[2], j};
                    if (next[0] < 0 || next[0] >= m || next[1] < 0 || next[1] >= n) {
                        continue;
                    }
                    if (next[0] == m - 1 && next[1] == n - 1) {
                        // grid[m - 1][n - 1] == 0
                        return cnt + 1;
                    }
                    if (grid[next[0]][next[1]] == 1) {
                        next[2]--;
                    }
                    //System.out.printf("%d, %d, %d, %d\n", next[0], next[1], next[2], next[3]);
                    if (next[2] < 0 || visited[next[0]][next[1]][next[2]]) {
                        // cannot pass this wall || visited.
                        continue;
                    }
                    visited[next[0]][next[1]][next[2]] = true;
                    q.offer(next);
                }
            }
            cnt++;
        }
        return -1;
    }
}