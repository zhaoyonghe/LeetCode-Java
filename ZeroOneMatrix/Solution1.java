package ZeroOneMatrix;

import java.util.LinkedList;

/**
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 * Runtime: 23ms
 * Rank: 47.09%
 */
public class Solution1 {
    public int m;
    public int n;
    public int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] updateMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        int[][] result = new int[m][n];

        LinkedList<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (queue.size() != 0) {
            int[] pos = queue.poll();
            for (int[] dir : direction) {
                if (!outOfRange(pos[0] + dir[0], pos[1] + dir[1])
                        && result[pos[0]][pos[1]] + 1 < result[pos[0] + dir[0]][pos[1] + dir[1]]) {
                    result[pos[0] + dir[0]][pos[1] + dir[1]] = result[pos[0]][pos[1]] + 1;
                    queue.offer(new int[]{pos[0] + dir[0], pos[1] + dir[1]});
                }
            }
        }

        return result;
    }

    public boolean outOfRange(int i, int j) {
        return i < 0 || i >= m || j < 0 || j >= n;
    }
}
