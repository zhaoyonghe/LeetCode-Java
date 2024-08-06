package SurroundedRegions_130;

/**
 * $$ Assume the board size is m * n.
 * $$ Time Complexity: O(m * n)
 * $$ Space Complexity: O(m * n)
 */
public class Solution1 {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') flip(board, i, 0);
            if (board[i][board[0].length - 1] == 'O') flip(board, i, board[0].length - 1);
        }
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') flip(board, 0, j);
            if (board[board.length - 1][j] == 'O') flip(board, board.length - 1, j);
        }
        setAll(board, 'O', 'X');
        setAll(board, 'p', 'O');
    }

    private void setAll(char[][] board, char a, char b) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == a) {
                    board[i][j] = b;
                }
            }
        }
    }

    private void flip(char[][] b, int i, int j) {
        if (i < 0 || i >= b.length || j < 0 || j >= b[i].length || b[i][j] != 'O') {
            // Reach the boarder.
            return;
        }
        b[i][j] = 'p';
        flip(b, i - 1, j);
        flip(b, i + 1, j);
        flip(b, i, j - 1);
        flip(b, i, j + 1);
    }
}