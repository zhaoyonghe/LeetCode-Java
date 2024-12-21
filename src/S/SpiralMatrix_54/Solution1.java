package S.SpiralMatrix_54;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume m is matrix.length and n is matrix[0].length.
 * Time Complexity: O(mn)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */

public class Solution1 {
    boolean cango(int[][] matrix, int xn, int yn) {
        int m = matrix.length;
        int n = matrix[0].length;
        return xn >= 0 && xn < m && yn >= 0 && yn < n && matrix[xn][yn] != 101;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i = 0;
        int x = 0;
        int y = 0;
        List<Integer> res = new ArrayList<>();
        while (true) {
            res.add(matrix[x][y]);
            matrix[x][y] = 101;
            int[] dir = dirs[i];
            // Can we go straight?
            int xn = x + dir[0];
            int yn = y + dir[1];
            if (!cango(matrix, xn, yn)) {
                // We cannot go straight. Change the direction.
                i = (i + 1) % 4;
                dir = dirs[i];
                xn = x + dir[0];
                yn = y + dir[1];
                if (!cango(matrix, xn, yn)) {
                    break;
                }
            }
            // Go.
            x = xn;
            y = yn;
        }
        return res;
    }
}