package R.RotateImage_48;

/**
 * $$ Assume n is the length of matrix.
 * $$ Time Complexity: O(n ^ 2)
 * $$ Auxiliary Space Complexity: O(1)
 */
public class Solution1 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int mm = n / 2;
        int nn = n / 2;
        if (n % 2 == 1) {
            mm++;
        }
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < mm; i++) {
            for (int j = 0; j < nn; j++) {
                a = matrix[i][j];
                b = matrix[j][n - i - 1];
                c = matrix[n - i - 1][n - j - 1];
                d = matrix[n - j - 1][i];
                matrix[i][j] = d;
                matrix[j][n - i - 1] = a;
                matrix[n - i - 1][n - j - 1] = b;
                matrix[n - j - 1][i] = c;
            }
        }
    }
}
