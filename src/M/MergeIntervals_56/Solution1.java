package M.MergeIntervals_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * $$ Assume intervals.length is n.
 * $$ Time Complexity: O(nlogn)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    // Important constraints:
    // 1. 0 <= start_i <= end_i <= 10 ^ 4 (input is valid)
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= cur[1]) {
                cur[1] = Math.max(cur[1], interval[1]);
                continue;
            }
            res.add(cur);
            cur = interval;
        }
        res.add(cur);
        return res.toArray(new int[res.size()][2]);
    }
}
