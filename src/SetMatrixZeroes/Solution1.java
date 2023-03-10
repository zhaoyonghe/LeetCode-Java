package SetMatrixZeroes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Assume m is number of rows, n is number of columns.
 * Time Complexity: O(m * n)
 * Space Complexity: O(m + n)
 * Runtime: 4ms
 * Rank: 37.80%
 */
public class Solution1 {
    public void setZeroes(int[][] matrix) {
        LinkedList<Integer> row = new LinkedList<>();
        LinkedList<Integer> column = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    column.add(j);
                }
            }
        }
        try {
            while (true) {
                int i = row.removeFirst();
                Arrays.fill(matrix[i], 0);
            }
        } catch (NoSuchElementException e) {

        }
        try {
            while (true) {
                int j = column.removeFirst();
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        } catch (NoSuchElementException e) {

        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] a = new int[4][5];
        System.out.println(a[2].length);
        System.out.println(Arrays.toString(a[1]));
        System.out.println(18 & 2);
    }

}
