package S.SpiralMatrix_54;

import java.util.ArrayList;
import java.util.List;

/**
 * $$ Assume m is matrix.length and n is matrix[0].length.
 * $$ Time Complexity: O(mn)
 * $$ Auxiliary Space Complexity: O(1)
 */

public class Solution1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] dirs = new int[][]{
                {0,1},{1,0},{0,-1},{-1,0}
        };

        int i = 0, j = 0;
        int dir = 0;
        int count = 0;
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        while (count < m * n) {
            count++;
            res.add(matrix[i][j]);
            matrix[i][j] = 101;
            int nexti = i + dirs[dir][0], nextj = j + dirs[dir][1];
            if (nexti < 0 || m <= nexti || nextj < 0 || n <= nextj || matrix[nexti][nextj] == 101) {
                dir = (dir + 1) % 4;
            }
            i += dirs[dir][0];
            j += dirs[dir][1];
        }
        return res;
    }
}