package PacificAtlanticWaterFlow_417;

import java.util.*;
/**
 * $$ Time Complexity: O(m * n)
 * $$ Space Complexity: O(m * n)
 */
public class Solution1 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length, n = heights[0].length;

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            q.offer(new int[]{i,0});
            pac[i][0] = true;
        }
        for (int j = 0; j < n; j++) {
            q.offer(new int[]{0,j});
            pac[0][j] = true;
        }
        bfs(q, pac, m, n, heights);
        for (int i = 0; i < m; i++) {
            q.offer(new int[]{i,n-1});
            atl[i][n-1] = true;
        }
        for (int j = 0; j < n; j++) {
            q.offer(new int[]{m-1,j});
            atl[m-1][j] = true;
        }
        bfs(q, atl, m, n, heights);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void bfs(Deque<int[]> q, boolean[][] visited, int m, int n, int[][] heights) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir: dirs) {
                int[] next = new int[]{cur[0]+dir[0],cur[1]+dir[1]};
                if (next[0] < 0 || next[0] >= m ||
                        next[1] < 0 || next[1] >= n ||
                        visited[next[0]][next[1]] || heights[cur[0]][cur[1]] > heights[next[0]][next[1]]) {
                    continue;
                }
                q.offer(next);
                visited[next[0]][next[1]] = true;
            }
        }
    }

    private int[][] dirs = new int[][]{
            {1,0},{-1,0},{0,1},{0,-1}
    };
}