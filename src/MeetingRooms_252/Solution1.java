package MeetingRooms_252;

import java.util.Arrays;
/**
 * Assume n is intervals.length.
 * Time Complexity: O(n * logn)
 * Auxiliary Space Complexity: O(n)
 * Runtime: 28ms
 * Rank: 54.04%
 */
public class Solution1 {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null) {
            return true;
        }
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0],b[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i-1][1]) {
                return false;
            }
        }
        return true;
    }
}