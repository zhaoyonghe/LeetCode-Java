package DetectSquares_2013;

import java.util.*;
/**
 * $$ Assume points.size() is n.
 * $$ Constructor Time Complexity: O(1)
 * $$ add() Time Complexity: O(1)
 * $$ count() Time Complexity: O(1)
 * $$ Space Complexity: O(n)
 */
public class DetectSquares1 {
    private int[][] plane = new int[1001][1001];
    private List<int[]> points = new ArrayList<>();

    public DetectSquares1() {

    }

    public void add(int[] point) {
        plane[point[0]][point[1]]++;
        points.add(point);
    }

    public int count(int[] point) {
        int sum = 0;
        for (int[] p : points) {
            if (!formSquare(p, point)) {
                continue;
            }
            sum += (plane[p[0]][point[1]] * plane[point[0]][p[1]]);
        }
        return sum;
    }

    private boolean formSquare(int[] pa, int[] pb) {
        return pa[0]-pb[0]!=0 &&pa[1]-pb[1]!=0&& Math.abs(pa[0]-pb[0]) == Math.abs(pa[1]-pb[1]);
    }
}