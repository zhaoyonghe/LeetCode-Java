package M.MinimumIntervalToIncludeEachQuery_1851;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * $$ Assume n is the length of intervals; q is the length of queries.
 * $$ Time Complexity: O(nlogn + qlogq)
 * $$ Space Complexity: O(n + q)
 */
public class Solution1 {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        Data[] qd = new Data[queries.length];
        for (int i = 0; i < queries.length; i++) {
            qd[i] = new Data(queries[i], i);
        }
        Arrays.sort(qd, (a, b) -> Integer.compare(a.point, b.point));

        int[] res = new int[queries.length];
        int start = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        for (Data data : qd) {
            while (start < intervals.length && intervals[start][0] <= data.point) {
                pq.offer(new int[]{intervals[start][1] - intervals[start][0] + 1, intervals[start][1]});
                start++;
            }
            while (!pq.isEmpty() && pq.peek()[1] < data.point) {
                pq.poll();
            }
            res[data.index] = pq.isEmpty() ? -1 : pq.peek()[0];
        }

        return res;
    }

    class Data {
        int point;
        int index;

        Data(int point, int index) {
            this.point = point;
            this.index = index;
        }
    }
}