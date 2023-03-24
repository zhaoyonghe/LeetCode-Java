package NonOverlappingIntervals_435;

import java.util.*;
/**
 * $$ Assume intervals.length is n.
 * $$ Time Complexity: O(nlogn)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public int eraseOverlapIntervals(int[][] intervals) {
        // sort
        Arrays.sort(intervals, (a, b)->Integer.compare(a[1],b[1]));

        int count = 0;
        // iterate through intervals
        // if an interval is overlapped with the previous one, it should be removed
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (overlap(prev, intervals[i])) {
                count++;
                continue;
            }
            prev = intervals[i];
        }

        return count;
    }

    private boolean overlap(int[] a, int[] b) {
        // a[1] <= b[1] is guaranteed
        return b[0] < a[1];
    }
}