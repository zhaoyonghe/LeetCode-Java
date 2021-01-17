package SearchA2DMatrixI;

/**
 * Assume matrix.length is m and matrix[0].length is n.
 * Time Complexity: O(logm + logn)
 * Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        // maybe in which row
        int row = -1;
        int low = 0;
        int high = m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid][0] < target) {
                if (mid == m - 1 || target < matrix[mid + 1][0]) {
                    row = mid;
                    break;
                } else {
                    low = mid + 1;
                }
            } else if (matrix[mid][0] > target) {
                if (mid == 0) {
                    return false;
                }
                if (matrix[mid - 1][0] < target) {
                    row = mid - 1;
                    break;
                } else {
                    high = mid - 1;
                }
            } else {
                return true;
            }
        }

        // maybe in which column
        low = 0;
        high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[row][mid] < target) {
                low = mid + 1;
            } else if (matrix[row][mid] > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
