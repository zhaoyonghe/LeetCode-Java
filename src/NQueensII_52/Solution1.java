package NQueensII_52;

/**
 * Time Complexity: O(n!)
 * Auxiliary Space Complexity: O(n)
 * Runtime: 1ms
 * Rank: 84.97%
 */
public class Solution1 {
    public int totalNQueens(int n) {
        int[] cur = new int[n];
        int[] res = new int[1];
        solve(0, cur, res);
        return res[0];
    }

    private void solve(int row, int[] cur, int[] res) {
        if (row == cur.length) {
            res[0]++;
            return;
        }
        test:
        for (int col = 0; col < cur.length; col++) {
            // Check queens before.
            for (int rowBefore = 0; rowBefore < row; rowBefore++) {
                int colBefore = cur[rowBefore];
                if (col == colBefore || Math.abs(row-rowBefore) == Math.abs(col-colBefore)) {
                    continue test;
                }
            }
            cur[row] = col;
            solve(row+1, cur, res);
        }
    }
}
