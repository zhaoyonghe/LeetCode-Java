package G.GameOfLife_289;

/**
 * Time Complexity: O(m * n)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */

public class Solution1 {
    private final int[][] dirs = new int[][]{
            {1, 1}, {1, 0}, {1, -1}, {0, 1}, {0, -1}, {-1, 1}, {-1, 0}, {-1, -1},
    };

    // Important constraints:
    // 1. m == board.length
    //    n == board[i].length
    //    1 <= m, n <= 25 (no need to null-check)
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = liveAroundCount(board, i, j);
                // System.out.printf("%d %d: %d\n", i, j, count);
                if (live(board[i][j]) && (count == 2 || count == 3)) {
                    board[i][j] |= 2;
                    continue;
                }
                if (count == 3) {
                    board[i][j] |= 2;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int liveAroundCount(int[][] board, int i, int j) {
        int count = 0;
        for (int[] dir : dirs) {
            count += liveCount(board, i + dir[0], j + dir[1]);
        }
        return count;
    }

    private int liveCount(int[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return 0;
        }
        return board[i][j] & 1;
    }

    private boolean live(int a) {
        return (a & 1) == 1;
    }
}