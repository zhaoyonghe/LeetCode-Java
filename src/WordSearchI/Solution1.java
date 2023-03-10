package WordSearchI;

/**
 * Assume board.length is m, board[0].length is n and word.length is len.
 * Time Complexity: O(m * n * len)
 * Space Complexity: O(m * n)
 * Runtime: 10ms
 * Rank: 86.65%
 */
public class Solution1 {
    int m = 0;
    int n = 0;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] track = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    track[i][j] = true;
                    boolean find = exist(board, track, i, j, word, 0);
                    if (find) {
                        return true;
                    }
                    track[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, boolean[][] track, int i, int j, String word, int k) {
        if (k == word.length() - 1 && board[i][j] == word.charAt(k)) {
            return true;
        }
        if (board[i][j] != word.charAt(k)) {
            return false;
        }
        boolean find = false;
        // go to right
        if (j + 1 < n && !track[i][j + 1]) {
            track[i][j + 1] = true;
            find = exist(board, track, i, j + 1, word, k + 1);
            track[i][j + 1] = false;
        }
        if (find) {
            return true;
        }
        // go to down
        if (i + 1 < m && !track[i + 1][j]) {
            track[i + 1][j] = true;
            find = exist(board, track, i + 1, j, word, k + 1);
            track[i + 1][j] = false;
        }
        if (find) {
            return true;
        }
        // go to left
        if (j - 1 >= 0 && !track[i][j - 1]) {
            track[i][j - 1] = true;
            find = exist(board, track, i, j - 1, word, k + 1);
            track[i][j - 1] = false;
        }
        if (find) {
            return true;
        }
        // go to up
        if (i - 1 >= 0 && !track[i - 1][j]) {
            track[i - 1][j] = true;
            find = exist(board, track, i - 1, j, word, k + 1);
            track[i - 1][j] = false;
        }
        return find;
    }
}
