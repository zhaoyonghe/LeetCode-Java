package D.DesignExcelSumFormula_631;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Constructor Time Complexity: O(height * width)
 * set() Time Complexity: O(1)
 * get() Time Complexity: O(height * width)
 * sum() Time Complexity: O(height * width)
 * Runtime: 9ms
 * Rank: 78.49%
 */
public class Excel1 {
    Cell[][] board;

    public Excel1(int height, char width) {
        this.board = new Cell[height + 1][width];
        for (int i = 0; i <= height; i++) {
            for (int j = 0; j < width; j++) {
                this.board[i][j] = new Cell();
            }
        }
    }

    public void set(int row, char column, int val) {
        Cell cell = this.board[row][column - 'A'];
        cell.val = val;
        cell.li.clear();
    }

    public int get(int row, char column) {
        return this.board[row][column - 'A'].val();
    }

    public int sum(int row, char column, String[] numbers) {
        Cell cell = this.board[row][column - 'A'];
        cell.li.clear();
        for (String num : numbers) {
            parseNum(cell.li, num);
        }
        return cell.val();
    }

    private void parseNum(List<Cell> li, String num) {
        String[] a = num.split(":");
        int[] pos1 = parsePos(a[0]);
        int[] pos2 = a.length == 1 ? pos1 : parsePos(a[1]);
        for (int row = pos1[0]; row <= pos2[0]; row++) {
            li.addAll(Arrays.asList(this.board[row]).subList(pos1[1], pos2[1] + 1));
        }
    }

    private int[] parsePos(String pos) {
        int col = pos.charAt(0) - 'A';
        int row = Integer.parseInt(pos.substring(1));
        return new int[]{row, col};
    }

    // Important constraints:
    // 1. 1 <= height <= 26, 'A' <= width <= 'Z'.
    // 2. 1 <= row <= height, 'A' <= column <= width.
    // 3. -100 <= val <= 100.
    // 4. numbers[i] has the format "ColRow" or "ColRow1:ColRow2".
    class Cell {
        int val = 0;
        List<Cell> li = new ArrayList<>();

        int val() {
            if (this.li == null || this.li.size() == 0) {
                return this.val;
            }
            int sum = 0;
            for (Cell c : this.li) {
                sum += c.val();
            }
            return sum;
        }
    }
}