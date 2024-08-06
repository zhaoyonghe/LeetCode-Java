package MeetingRoomsII_253;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * $$ Assume intervals.length is n.
 * $$ Time Complexity: O(nlogn)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            int earliestEnd = pq.poll();
            if (intervals[i][0] < earliestEnd) {
                // cannot arrange this meeting to even the most available meeting room
                pq.offer(earliestEnd);
                pq.offer(intervals[i][1]);
                continue;
            }
            pq.offer(intervals[i][1]);
        }

        return pq.size();
    }
}