package NQueensI_51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time Complexity: O(n!)
 * Auxiliary Space Complexity: O(n)
 * Runtime: 2ms
 * Rank: 92.60%
 */
public class Solution1 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] cur = new int[n];
        solve(0, cur, res);
        return res;
    }

    private List<String> drawBoard(int[] cur) {
        List<String> board = new ArrayList<>();
        int n = cur.length;
        char[] line = new char[n];
        for (int i : cur) {
            Arrays.fill(line, '.');
            line[i] = 'Q';
            board.add(new String(line));
        }
        return board;
    }

    private void solve(int row, int[] cur, List<List<String>> res) {
        if (row == cur.length) {
            res.add(drawBoard(cur));
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
