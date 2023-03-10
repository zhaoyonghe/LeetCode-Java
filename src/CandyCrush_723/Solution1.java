package CandyCrush_723;

/**
 * Time Complexity: O(m ^ 2 * n ^ 2)
 * Auxiliary Space Complexity: O(m)
 * Runtime: 8ms
 * Rank: 43.29%
 */

public class Solution1 {
    // Important constraints:
    // 1. 1 <= board[i][j] <= 2000.
    int m, n;
    int[] falls;

    public int[][] candyCrush(int[][] board) {
        this.m = board.length;
        this.n = board[0].length;
        falls = new int[m];
        while (clear(board)) {
            fall(board);
        }
        return board;
    }

    private void fall(int[][] board) {
        for (int j = 0; j < n; j++) {
            int cur = 0;
            for (int i = m - 1; i >= 0; i--) {
                if (board[i][j] != 0) {
                    falls[i] = cur;
                    continue;
                }
                cur++;
                falls[i] = 0;
            }
            for (int i = m - 1; i >= 0; i--) {
                board[i + falls[i]][j] = board[i][j];
                if (falls[i] != 0) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private boolean clear(int[][] board) {
        for (int i = 0; i < m; i++) {
            int a = 0, b = 0;
            while (true) {
                if (b == n) {
                    if (b - a < 3) {
                        break;
                    }
                    int val = -Math.abs(board[i][a]);
                    for (int j = a; j < b; j++) {
                        board[i][j] = val;
                    }
                    break;
                }
                if (Math.abs(board[i][a]) == Math.abs(board[i][b])) {
                    b++;
                    continue;
                }
                if (b - a < 3) {
                    a = b;
                    continue;
                }
                int val = -Math.abs(board[i][a]);
                for (int j = a; j < b; j++) {
                    board[i][j] = val;
                }
                a = b;
            }
        }
        for (int j = 0; j < n; j++) {
            int a = 0, b = 0;
            while (true) {
                if (b == m) {
                    if (b - a < 3) {
                        break;
                    }
                    int val = -Math.abs(board[a][j]);
                    for (int i = a; i < b; i++) {
                        board[i][j] = val;
                    }
                    break;
                }
                if (Math.abs(board[a][j]) == Math.abs(board[b][j])) {
                    b++;
                    continue;
                }
                if (b - a < 3) {
                    a = b;
                    continue;
                }
                int val = -Math.abs(board[a][j]);
                for (int i = a; i < b; i++) {
                    board[i][j] = val;
                }
                a = b;
            }
        }
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] >= 0) {
                    continue;
                }
                flag = true;
                board[i][j] = 0;
            }
        }
        return flag;
    }
}