package Minesweeper_529;

/**
 * Time Complexity: O(m * n)
 * Auxiliary Space Complexity: O(m * n)
 * Runtime: 0ms
 * Rank: 100.00%
 */

public class Solution1 {
    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0];
        int c = click[1];
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        }
        // board[r][c] == 'E'
        dfs(board, r, c);
        return board;
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'E') {
            return;
        }
        int minesAround = countMinesAround(board, r, c);
        if (minesAround > 0) {
            board[r][c] = (char) ((int) ('0') + minesAround);
            return;
        }
        board[r][c] = 'B';
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                dfs(board, r + i, c + j);
            }
        }
    }

    private int countMinesAround(char[][] board, int r, int c) {
        int res = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                res += countMineHere(board, r + i, c + j);
            }
        }
        return res;
    }

    private int countMineHere(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'M') {
            return 0;
        }
        return 1;
    }
}