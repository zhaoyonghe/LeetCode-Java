package CourseScheduleII;

import java.util.ArrayList;
import java.util.List;
/**
 * Best Time Complexity: O(max(|V|, |E|))
 * Worst Time Complexity: O(max(|V| ^ 2, |E| ^ 2))
 * Space Complexity: O(|E|)
 * Runtime: 119ms
 * Rank: 8.09%
 */
public class Solution1 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<int[]> graph = new ArrayList<>();
		for (int[] edge : prerequisites) {
			graph.add(edge);
		}

		boolean[] coursesLastTime = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			coursesLastTime[i] = true;
		}

		int remainCourses = numCourses;

		int[] result = new int[numCourses];
		int j = 0;

		while (j < numCourses) {
			boolean[] coursesThisTime = new boolean[numCourses];

			int count = 0;

			for (int[] edge : graph) {
				if (!coursesThisTime[edge[0]]) {
					count += 1;
					coursesThisTime[edge[0]] = true;
				}
			}

			if (count == remainCourses) {
				return new int[] {};
			}

			remainCourses = count;

			for (int i = 0; i < numCourses; i++) {
				if (coursesLastTime[i] ^ coursesThisTime[i]) {
					result[j] = i;
					j += 1;
				}
			}

			coursesLastTime = coursesThisTime;

			List<int[]> newGraph = new ArrayList<>();

			for (int[] edge : graph) {
				if (coursesThisTime[edge[1]]) {
					newGraph.add(edge);
				}
			}

			graph = newGraph;
		}

		return result;
	}
}
