package SudokuSolver;

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * Runtime: 4ms
 * Rank: 92.24%
 */
public class Solution2 {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    rows[i][board[i][j] - '1'] = true;
                    cols[j][board[i][j] - '1'] = true;
                    boxes[(i / 3) * 3 + j / 3][board[i][j] - '1'] = true;
                }
            }
        }

        dfs(board, 0, rows, cols, boxes);
    }

    public boolean dfs(char[][] board, int i, boolean[][] rows, boolean[][] cols, boolean[][] boxes) {
        if (i == 81) {
            return true;
        }

        int r = i / 9;
        int c = i % 9;

        if (board[r][c] != '.') {
            return dfs(board, i + 1, rows, cols, boxes);
        }

        for (int num = 0; num < 9; num++) {
            if (!rows[r][num] && !cols[c][num] && !boxes[(r / 3) * 3 + c / 3][num]) {
                rows[r][num] = true;
                cols[c][num] = true;
                boxes[(r / 3) * 3 + c / 3][num] = true;
                board[r][c] = (char) ((int) '1' + num);
                if (dfs(board, i + 1, rows, cols, boxes)) {
                    return true;
                }
                rows[r][num] = false;
                cols[c][num] = false;
                boxes[(r / 3) * 3 + c / 3][num] = false;
                board[r][c] = '.';
            }
        }

        return false;
    }
}
