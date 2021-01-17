package SudokuSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * Runtime: 12ms
 * Rank: 32.17%
 */
public class Solution1 {
    public void solveSudoku(char[][] board) {
        ArrayList<HashSet<Integer>> pos = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    HashSet<Integer> temp = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
                    for (int k = 0; k < 9; k++) {
                        if (board[i][k] != '.') {
                            temp.remove(board[i][k] - '0');
                        }
                        if (board[k][j] != '.') {
                            temp.remove(board[k][j] - '0');
                        }
                    }
                    for (int m = (i / 3) * 3; m < (i / 3) * 3 + 3; m++) {
                        for (int n = (j / 3) * 3; n < (j / 3) * 3 + 3; n++) {
                            if (board[m][n] != '.') {
                                temp.remove(board[m][n] - '0');
                            }
                        }
                    }
                    pos.add(temp);
                } else {
                    pos.add(null);
                }
            }
        }

        // System.out.println(pos);

        char[][] fill = board.clone();

        dfs(fill, board, pos, 0);
        board = null;
        board = fill;
    }

    public boolean dfs(char[][] fill, char[][] board, ArrayList<HashSet<Integer>> pos, int i) {
        if (i == 81) {
            return true;
        }

        if (board[i / 9][i % 9] != '.') {
            return dfs(fill, board, pos, i + 1);
        }

        for (int num : pos.get(i)) {
            if (check(fill, i / 9, i % 9, num)) {
                fill[i / 9][i % 9] = (char) (num + (int) '0');
                if (dfs(fill, board, pos, i + 1)) {
                    return true;
                } else {
                    fill[i / 9][i % 9] = '.';
                }
            }
        }
        // System.out.println("d");
        return false;
    }

    public boolean check(char[][] fill, int i, int j, int num) {
        for (int k = 0; k < 9; k++) {
            if (fill[i][k] != '.' && fill[i][k] - '0' == num) {
                return false;
            }
            if (fill[k][j] != '.' && fill[k][j] - '0' == num) {
                return false;
            }
        }
        for (int m = (i / 3) * 3; m < (i / 3) * 3 + 3; m++) {
            for (int n = (j / 3) * 3; n < (j / 3) * 3 + 3; n++) {
                if (fill[m][n] != '.' && fill[m][n] - '0' == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
