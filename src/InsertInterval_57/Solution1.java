package InsertInterval_57;

import java.util.*;
/**
 * $$ Assume intervals.length is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        Deque<int[]> st = new ArrayDeque<>();
        int i = 0;
        while (true) {
            if (i == n && newInterval == null) {
                break;
            }
            int[] cur;
            if (i == n) {
                cur = newInterval;
                newInterval = null;
            } else if (newInterval == null) {
                cur = intervals[i];
                i++;
            } else {
                if (newInterval[0] < intervals[i][0]) {
                    cur = newInterval;
                    newInterval = null;
                } else {
                    cur = intervals[i];
                    i++;
                }
            }

            if (st.isEmpty()) {
                st.push(cur);
                continue;
            }
            int[] prev = st.peek();
            if (overlap(prev, cur)) {
                st.pop();
                st.push(merge(prev, cur));
                continue;
            }
            st.push(cur);
        }

        int[][] res=new int[st.size()][2];
        i = st.size() - 1;
        while (!st.isEmpty()) {
            res[i] = st.pop();
            i--;
        }
        return res;
    }

    private boolean overlap(int[] a, int[] b) {
        // a <= b is guaranteed.
        // so we only need to check whether b[0] <= a[1].
        return b[0] <= a[1];
    }

    private int[] merge(int[] a, int[] b) {
        // a, b overlap are guaranteed.
        return new int[]{Math.min(a[0], b[0]),Math.max(a[1],b[1])};
    }
}