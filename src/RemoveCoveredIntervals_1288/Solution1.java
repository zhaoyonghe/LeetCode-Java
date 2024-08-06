package RemoveCoveredIntervals_1288;

import java.util.Arrays;

/**
 * $$ Assume intervals.length is n.
 * $$ Time Complexity: O(nlogn)
 * $$ Space Complexity: O(logn)
 */
public class Solution1 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));

        int count = 0, right = 0;
        for (int[] interval : intervals) {
            if (right < interval[1]) {
                right = interval[1];
                continue;
            }
            count++;
        }
        return intervals.length - count;
    }
}