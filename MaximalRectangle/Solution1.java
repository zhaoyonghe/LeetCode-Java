package MaximalRectangle;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 * Runtime: 9ms
 * Rank: 79.99%
 */
public class Solution1 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] model = new int[m + 1][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    model[i][j] = model[i + 1][j] + 1;
                }
            }
        }
        /*
         * for(int i = 0; i <= m; i++) { System.out.println(Arrays.toString(model[i]));
         * } System.out.println("===============================");
         */
        int res = 0;

        for (int i = 0; i < m; i++) {
            // System.out.println(Arrays.toString(model[i]));
            res = Math.max(res, largestRectangleArea(model[i]));
        }

        return res;
    }

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> indexStack = new ArrayDeque<>();
        indexStack.push(-1);

        for (int i = 0; i < heights.length; i++) {
            while (indexStack.peek() != -1 && heights[indexStack.peek()] > heights[i]) {
                int h = heights[indexStack.pop()];
                res = Math.max(res, h * (i - indexStack.peek() - 1));
            }
            indexStack.push(i);
        }

        while (indexStack.peek() != -1 && heights[indexStack.peek()] > 0) {
            int index = indexStack.pop();
            int h = heights[index];
            res = Math.max(res, h * (heights.length - indexStack.peek() - 1));
        }

        return res;
    }
}
