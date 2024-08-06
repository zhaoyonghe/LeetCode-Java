package IntervalListIntersections_986;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(m + n)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 3ms
 * Rank: 89.17%
 */
public class Solution1 {
    // Important constraints:
    // 1. start_i < end_i, end_i < start_j+1 (input is valid)
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        int m = firstList.length, n = secondList.length;
        while (i < m && j < n) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            if (start <= end) {
                res.add(new int[]{start, end});
            }
            if (firstList[i][1] <= secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}