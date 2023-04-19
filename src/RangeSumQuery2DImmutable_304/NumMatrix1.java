package RangeSumQuery2DImmutable_304;
/**
 * $$ Assume the matrix size is m * n.
 * $$ Constructor Time Complexity: O(m * n)
 * $$ sumRegion() Complexity: O(1)
 */
class NumMatrix1 {

    int[][] sum;

    public NumMatrix1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        sum = new int[m][n];
        sum[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            sum[i][0] = sum[i-1][0]+matrix[i][0];
        }
        for (int j = 1; j < n; j++) {
            sum[0][j] = sum[0][j-1]+matrix[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int a = sum[row2][col2];
        int b = 0;
        if (row1 > 0) {
            b = sum[row1-1][col2];
        }
        int c = 0;
        if (col1 > 0) {
            c = sum[row2][col1-1];
        }
        int d = 0;
        if (row1 > 0 && col1 > 0) {
            d = sum[row1 -1][col1-1];
        }
        return a-b-c+d;
    }
}