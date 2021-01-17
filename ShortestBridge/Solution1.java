package ShortestBridge;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 * Runtime: 12ms
 * Rank: 77.18%
 */
public class Solution1 {
    private int m;
    private int n;

    public int shortestBridge(int[][] A) {
        m = A.length;
        n = A[0].length;

        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];

        end:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, queue, visited);
                    break end;
                }
            }
        }

        // System.out.println("queue");

        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int path = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();

            for (int i = 0; i < sz; i++) {
                int[] pos = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int ii = pos[0] + direction[j][0];
                    int jj = pos[1] + direction[j][1];
                    // System.out.println(ii+ " "+ jj);
                    if (ii >= 0 && ii < m && jj >= 0 && jj < n && !visited[ii][jj]) {
                        if (A[ii][jj] == 1) {
                            return path;
                        } else {
                            queue.offer(new int[]{ii, jj});
                            visited[ii][jj] = true;
                        }
                    }
                }
            }

            path += 1;
        }

        return -1;
    }

    public void dfs(int[][] A, int i, int j, Deque<int[]> queue, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || A[i][j] == 0 || visited[i][j]) {
            return;
        }

        // System.out.println("dd");

        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int k = 0; k < 4; k++) {
            dfs(A, i + direction[k][0], j + direction[k][1], queue, visited);
        }
    }
}
