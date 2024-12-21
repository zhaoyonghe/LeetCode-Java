package W.WordSearch_79;

/**
 * $$ Assume board.length is m, board[0].length is n.
 * $$ Time Complexity: O(m^2 * n^2)
 * $$ Space Complexity: O(m * n)
 */
public class Solution1 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, visited, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }

        if (visited[i][j] || board[i][j] != word.charAt(k)) {
            return false;
        }

        if (k == word.length() - 1 && board[i][j] == word.charAt(k)) {
            return true;
        }

        visited[i][j] = true;

        boolean find = dfs(board, visited, i, j + 1, word, k + 1) || dfs(board, visited, i + 1, j, word, k + 1)
                || dfs(board, visited, i, j - 1, word, k + 1) || dfs(board, visited, i - 1, j, word, k + 1);

        visited[i][j] = false;

        return find;
    }
}
