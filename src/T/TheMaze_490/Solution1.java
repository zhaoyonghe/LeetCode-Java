package T.TheMaze_490;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 * Runtime: 6ms
 * Rank: 50.25%
 */
public class Solution1 {
    int[][] dirs = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    // Important constraints:
    // 1. m == maze.length, n == maze[i].length, 1 <= m, n <= 100
    // 2. maze[i][j] is 0 or 1.
    // 3. start.length == 2, destination.length == 2
    // 4. 0 <= start[0], destination[0] <= m
    // 5. 0 <= start[1], destination[1] <= n
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(start);
        maze[start[0]][start[1]] = -1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int[] next = find(maze, cur, j);
                    if (maze[next[0]][next[1]] == -1) {
                        continue;
                    }
                    // Both the ball and the destination exist in an empty space, and they will not be in the same position initially. So we can put this if statement after the previous one.
                    if (Arrays.equals(next, destination)) {
                        return true;
                    }
                    maze[next[0]][next[1]] = -1;
                    q.offer(next);
                }
            }
        }
        return false;
    }

    private int[] find(int[][] maze, int[] cur, int i) {
        int[] next = Arrays.copyOf(cur, 2);
        while (true) {
            int[] dir = dirs[i];
            next[0] += dir[0];
            next[1] += dir[1];
            if (next[0] < 0 || next[1] < 0 || next[0] >= maze.length || next[1] >= maze[0].length || maze[next[0]][next[1]] == 1) {
                next[0] -= dir[0];
                next[1] -= dir[1];
                break;
            }
        }
        return next;
    }
}