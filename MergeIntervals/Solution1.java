package MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;
/**
 * Assume n is intervals.length
 * Time Complexity: O(n * logn)
 * Space Complexity: O(1)
 * Runtime: 22ms
 * Rank: 90.00%
 */
public class Solution1 {
	public int[][] merge(int[][] intervals) {
		if (intervals.length == 1 || intervals.length == 0) {
			return intervals;
		}
		Arrays.sort(intervals, new MyComparator());

		int[] merged = new int[intervals.length];
		int mergedCount = 0;
		int i = 0;
		int j = 1;
		while (i < intervals.length) {
			while (j < intervals.length) {
				if (intervals[i][1] >= intervals[j][0]) {
					intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
					merged[j] = -1;
					mergedCount += 1;
					j += 1;
				} else {
					break;
				}
			}
			i = j;
			j += 1;
		}

		if (mergedCount == 0) {
			return intervals;
		}

		int[][] result = new int[intervals.length - mergedCount][2];
		int n = 0;
		for (int m = 0; m < intervals.length; m++) {
			if (merged[m] == 0) {
				result[n][0] = intervals[m][0];
				result[n][1] = intervals[m][1];
				n += 1;
			}
		}
		return result;
	}

	class MyComparator implements Comparator<Object> {
		public int compare(Object arg0, Object arg1) {
			int[] interval1 = (int[]) arg0;
			int[] interval2 = (int[]) arg1;

			return interval1[0] - interval2[0];

		}
	}
}
