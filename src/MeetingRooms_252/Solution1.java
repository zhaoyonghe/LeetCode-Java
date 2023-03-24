package MeetingRooms_252;

import java.util.Arrays;
/**
 * $$ Assume intervals.length is n.
 * $$ Time Complexity: O(nlogn)
 * $$ Auxiliary Space Complexity: O(n)
 */
public class Solution1 {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i-1][1]) {
                return false;
            }
        }
        return true;
    }
}