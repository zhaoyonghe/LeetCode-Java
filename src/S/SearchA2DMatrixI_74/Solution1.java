package S.SearchA2DMatrixI_74;

/**
 * $$ Assume matrix.length is m and matrix[0].length is n.
 * $$ Time Complexity: O(logm + logn)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = greatestSE(matrix, target);
        if (i == -1) {
            return false;
        }
        return binarySearch(matrix[i], target);
    }

    private int greatestSE(int[][] matrix, int target) {
        int s = 0;
        int e = matrix.length;
        while (s <= e) {
            int m = (s + e) / 2;
            if (matrix[m][0] < target) {
                if (m + 1 < matrix.length && matrix[m + 1][0] <= target) {
                    s = m + 1;
                    continue;
                }
                return m;
            } else if (matrix[m][0] > target) {
                e = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    private boolean binarySearch(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int m = (s + e) / 2;
            if (arr[m] < target) {
                s = m + 1;
            } else if (arr[m] > target) {
                e = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
