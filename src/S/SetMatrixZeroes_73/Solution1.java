package S.SetMatrixZeroes_73;

/**
 * $$ Assume m is number of rows, n is number of columns.
 * $$ Time Complexity: O(m * n)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false, firstCol = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] != 0) {
                continue;
            }
            firstCol = true;
            break;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] != 0) {
                continue;
            }
            firstRow = true;
            break;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    continue;
                }
                matrix[0][j] = 0;
                matrix[i][0] = 0;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] != 0) {
                continue;
            }
            setRowZeros(matrix, i);
        }
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] != 0) {
                continue;
            }
            setColZeros(matrix, j);
        }
        if (firstRow) {
            setRowZeros(matrix, 0);
        }
        if (firstCol) {
            setColZeros(matrix, 0);
        }
    }

    private void setRowZeros(int[][] matrix, int row) {
        for (int j = 0; j < matrix[row].length; j++) {
            matrix[row][j] = 0;
        }
    }

    private void setColZeros(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}
