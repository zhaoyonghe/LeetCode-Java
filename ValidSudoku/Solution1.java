package ValidSudoku;

import java.util.BitSet;

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * Runtime: 19ms
 * Rank: 95.65%
 */
public class Solution1 {
    public boolean isValidSudoku(char[][] board) {
        BitSet bs = new BitSet(9);
        // Check rows.
        for (int i = 0; i < 9; i++) {
            int count = 0;
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    bs.set(board[i][j] - 49);
                    count++;
                }
            }
            if (count > bs.cardinality()) {
                return false;
            } else {
                bs.clear();
            }
        }
        // Check columns.
        for (int j = 0; j < 9; j++) {
            int count = 0;
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    bs.set(board[i][j] - 49);
                    count++;
                }
            }
            if (count > bs.cardinality()) {
                return false;
            } else {
                bs.clear();
            }
        }
        // Check 3 * # squares.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int count = 0;
                for (int m = i * 3; m < i * 3 + 3; m++) {
                    for (int n = j * 3; n < j * 3 + 3; n++) {
                        if (board[m][n] != '.') {
                            bs.set(board[m][n] - 49);
                            count++;
                        }
                    }
                }
                if (count > bs.cardinality()) {
                    return false;
                } else {
                    bs.clear();
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BitSet bs = new BitSet(9);
        bs.set(1);
        System.out.println(bs.cardinality());
        System.out.println(bs.toString());
        bs.set(2);
        System.out.println(bs.cardinality());
        System.out.println(bs.toString());
        bs.set(3, 7);
        System.out.println(bs.cardinality());
        System.out.println(bs.toString());
        bs.clear(2, 4);
        System.out.println(bs.cardinality());
        System.out.println(bs.toString());
        long begintime;
        long endtime;
        long costTime;
        begintime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            bs.cardinality();
        }
        endtime = System.nanoTime();
        costTime = (endtime - begintime) / 1000;
        System.out.println(costTime);
        begintime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 9; j++) {
                bs.get(j);
            }
        }
        endtime = System.nanoTime();
        costTime = (endtime - begintime) / 1000;
        System.out.println(costTime);

    }

}
