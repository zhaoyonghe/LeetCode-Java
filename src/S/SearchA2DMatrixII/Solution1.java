package S.SearchA2DMatrixII;

/**
 * T(m * n) = 3 * T(m * n) + O(1)
 * Time Complexity: O((m * n) ^ log_4^3)
 * Space Complexity: O(log_4^(m * n))
 * Runtime: 17ms
 * Rank: 24.50%
 */
public class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        return searchMatrix(matrix, target, 0, 0, m - 1, n - 1);
    }

    public boolean searchMatrix(int[][] matrix, int target, int i, int j, int ii, int jj) {
        if (i > ii || j > jj) {
            return false;
        }
        // System.out.println("(" + String.valueOf(i) + "," + String.valueOf(j) + "," +
        // String.valueOf(ii) + "," + String.valueOf(jj) + ")");

        if (matrix[i][j] == target || matrix[ii][jj] == target) {
            return true;
        }

        if (matrix[i][j] > target || matrix[ii][jj] < target) {
            return false;
        }

        return searchMatrix(matrix, target, i, j, (i + ii) / 2, (j + jj) / 2)
                || searchMatrix(matrix, target, (i + ii) / 2 + 1, j, ii, (j + jj) / 2)
                || searchMatrix(matrix, target, i, (j + jj) / 2 + 1, (i + ii) / 2, jj)
                || searchMatrix(matrix, target, (i + ii) / 2 + 1, (j + jj) / 2 + 1, ii, jj);
    }
}
