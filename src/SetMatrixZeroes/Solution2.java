package SetMatrixZeroes;

/**
 * Assume m is number of rows, n is number of columns.
 * Time Complexity: O(m * n)
 * Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 83.35%
 */
public class Solution2 {
    public void setZeroes(int[][] matrix) {
        // Use first row and first column to mark.
        boolean rowflag = false;
        boolean colflag = false;
        // matrix mn
        // number of rows
        int m = matrix.length;
        // number of columns
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                colflag = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                rowflag = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowflag) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (colflag) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
