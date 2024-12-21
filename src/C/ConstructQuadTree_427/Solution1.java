package C.ConstructQuadTree_427;

/**
 * Time Complexity: O(n ^ 2)
 * Auxiliary Space Complexity: O(n ^ 2)
 * Runtime: 2ms
 * Rank: 57.38%
 */
public class Solution1 {
// Important constraints:

    public Node construct(int[][] grid) {
        int n = grid.length;
        int[][] sum = new int[n + 1][n + 1];
        sum[1][1] = grid[0][0];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        return construct(sum, n, 1, 1);
    }

    private Node construct(int[][] sum, int n, int iStart, int jStart) {
        int s = blockSum(sum, n, iStart, jStart);
        if (s == n * n) {
            return new Node(true, true);
        }
        if (s == 0) {
            return new Node(false, true);
        }
        // n = 2 ^ k
        int m = n / 2;
        Node root = new Node(false, false);
        int tlSum = blockSum(sum, m, iStart, jStart);
        if (tlSum == m * m) {
            root.topLeft = new Node(true, true);
        } else if (tlSum == 0) {
            root.topLeft = new Node(false, true);
        } else {
            root.topLeft = construct(sum, m, iStart, jStart);
        }
        int trSum = blockSum(sum, m, iStart, jStart + m);
        if (trSum == m * m) {
            root.topRight = new Node(true, true);
        } else if (trSum == 0) {
            root.topRight = new Node(false, true);
        } else {
            root.topRight = construct(sum, m, iStart, jStart + m);
        }
        int blSum = blockSum(sum, m, iStart + m, jStart);
        if (blSum == m * m) {
            root.bottomLeft = new Node(true, true);
        } else if (blSum == 0) {
            root.bottomLeft = new Node(false, true);
        } else {
            root.bottomLeft = construct(sum, m, iStart + m, jStart);
        }
        int brSum = blockSum(sum, m, iStart + m, jStart + m);
        if (brSum == m * m) {
            root.bottomRight = new Node(true, true);
        } else if (brSum == 0) {
            root.bottomRight = new Node(false, true);
        } else {
            root.bottomRight = construct(sum, m, iStart + m, jStart + m);
        }
        return root;
    }

    private int blockSum(int[][] sum, int n, int iStart, int jStart) {
        return sum[iStart + n - 1][jStart + n - 1] + sum[iStart - 1][jStart - 1] - sum[iStart + n - 1][jStart - 1] - sum[iStart - 1][jStart + n - 1];
    }
}
