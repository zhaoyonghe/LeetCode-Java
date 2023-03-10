package EmployeeFreeTime_759;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Assume average schedule.length is n and average schedule[i].length is m.
 * Time Complexity: O(m * n * log(n))
 * Auxiliary Space Complexity: O(n)
 * Runtime: 19ms
 * Rank: 37.67%
 */
public class Solution1 {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(schedule.get(a[0]).get(a[1]).start, schedule.get(b[0]).get(b[1]).start);
        });
        for (int i = 0; i < schedule.size(); i++) {
            // schedule[i].length >= 1
            pq.offer(new int[]{i, 0});
        }
        Interval last = null;
        while (pq.size() > 0) {
            int[] pos = pq.poll();
            // schedule[i].length >= 1
            Interval cur = schedule.get(pos[0]).get(pos[1]);
            if (last == null) {
                last = cur;
            } else {
                if (cur.start <= last.end) {
                    last.end = Math.max(last.end, cur.end);
                } else {
                    res.add(new Interval(last.end, cur.start));
                    last = cur;
                }
            }

            if (pos[1] + 1 < schedule.get(pos[0]).size()) {
                pq.offer(new int[]{pos[0], pos[1] + 1});
            }
        }

        return res;
    }
}