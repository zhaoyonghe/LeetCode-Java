package MaximalRectangle_85;

/**
 * $$ Time Complexity: O(m * n)
 * $$ Auxiliary Space Complexity: O(n)
 */
public class Solution1 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] line = new int[n];
        int max = maxRec(line);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                line[j] = i == 0 ? (matrix[i][j] == '0' ? 0 : 1) : (matrix[i][j] == '0' ? 0 : line[j] + 1);
            }
            max = Math.max(max, maxRec(line));
        }
        return max;
    }

    private int maxRec(int[] line) {
        int max = 0;
        for (int i = 0; i < line.length; i++) {
            int a = i, b = i;
            while (a > 0 && line[a - 1] >= line[i]) {
                a--;
            }
            while (b < line.length - 1 && line[b + 1] >= line[i]) {
                b++;
            }
            max = Math.max(max, line[i] * (b - a + 1));
        }
        return max;
    }
}
