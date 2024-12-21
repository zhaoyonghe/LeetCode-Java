package W.WallsAndGates_286;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * $$ Assume rooms is an m * n matrix.
 * $$ Time Complexity: O(mn)
 * $$ Space Complexity: O(mn)
 */
public class Solution1 {
    private final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        Deque<int[]> q = new ArrayDeque<>();

        // for every gate, bfs and update the distances
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] != 0) {
                    continue;
                }
                // rooms[i][j] is a gate
                q.offer(new int[]{i, j});
            }
        }
        bfs(rooms, q);
    }

    private void bfs(int[][] rooms, Deque<int[]> q) {
        int dis = 0;
        while (!q.isEmpty()) {
            dis++;
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int nextx = cur[0] + dir[0];
                    int nexty = cur[1] + dir[1];
                    if (nextx < 0 || nextx >= rooms.length || nexty < 0 || nexty >= rooms[0].length || rooms[nextx][nexty] != Integer.MAX_VALUE) {
                        continue;
                    }
                    rooms[nextx][nexty] = dis;
                    q.offer(new int[]{nextx, nexty});
                }

            }
        }
    }
}