package ValidSudoku_36;

import java.util.Arrays;

/**
 * $$ Time Complexity: O(1)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public boolean isValidSudoku(char[][] board) {
        int[] map = new int[9];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(map, 0);
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (map[c - '1'] > 0) {
                    return false;
                }
                map[c - '1']++;
            }
        }
        for (int j = 0; j < 9; j++) {
            Arrays.fill(map, 0);
            for (int i = 0; i < 9; i++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (map[c - '1'] > 0) {
                    return false;
                }
                map[c - '1']++;
            }
        }
        for (int i = 0; i < 9; i++) {
            Arrays.fill(map, 0);
            for (int j = 0; j < 9; j++) {
                char c = board[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3];
                if (c == '.') {
                    continue;
                }
                if (map[c - '1'] > 0) {
                    return false;
                }
                map[c - '1']++;
            }
        }
        return true;
    }
}
