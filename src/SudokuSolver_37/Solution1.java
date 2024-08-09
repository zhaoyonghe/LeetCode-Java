package SudokuSolver_37;

/**
 * $$ Time Complexity: O(1)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                int numIndex = board[r][c] - '1';
                int b = r / 3 * 3 + c / 3;
                rows[r][numIndex] = true;
                cols[c][numIndex] = true;
                boxes[b][numIndex] = true;
            }
        }
        solve(board, 0, rows, cols, boxes);
    }

    private boolean solve(char[][] board, int n, boolean[][] rows, boolean[][] cols, boolean[][] boxes) {
        if (n == 81) {
            return true;
        }
        int r = n / 9;
        int c = n % 9;
        if (board[r][c] != '.') {
            return solve(board, n + 1, rows, cols, boxes);
        }
        int b = r / 3 * 3 + c / 3;

        for (int a = 0; a < 9; a++) {
            if (rows[r][a] || cols[c][a] || boxes[b][a]) {
                continue;
            }
            char ca = (char) ((int) '1' + a);
            rows[r][a] = true;
            cols[c][a] = true;
            boxes[b][a] = true;
            if (solve(board, n + 1, rows, cols, boxes)) {
                board[r][c] = ca;
                return true;
            }
            rows[r][a] = false;
            cols[c][a] = false;
            boxes[b][a] = false;
        }
        return false;
    }
}
