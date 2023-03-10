package MeetingRoomsII_253;

import java.util.*;
/**
 * Assume n is intervals.length.
 * Time Complexity: O(n * logn)
 * Auxiliary Space Complexity: O(n)
 * Runtime: 6ms
 * Rank: 80.45%
 */
public class Solution1 {
    public int minMeetingRooms(int[][] intervals) {
        // Important constraints:
        // 1 <= intervals.length <= 10^4 (at least one input element)
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->Integer.compare(a[1],b[1]));
        pq.offer(intervals[0]);
        for (int i  = 1; i < intervals.length; i++){
            int[] now = intervals[i];
            int[] before = pq.poll();
            if (before[1] <= now[0]) {
                before[1] = now[1];
            } else {
                pq.offer(now);
            }
            pq.offer(before);
        }
        return pq.size();
    }
}