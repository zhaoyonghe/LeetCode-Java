package CourseScheduleII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Time Complexity: O(|V| + |E|)
 * Space Complexity: O(max(|V|, |E|))
 * Runtime: 6ms
 * Rank: 93.58%
 */

public class Solution3 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		// build graph
		ArrayList<HashSet<Integer>> graph = new ArrayList<>(numCourses);

		for (int i = 0; i < numCourses; i++) {
			graph.add(new HashSet<Integer>());
		}

		for (int i = 0; i < prerequisites.length; i++) {
			graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}

		// dfs, detect cycles, topological sort
		int[] status = new int[numCourses];
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < numCourses; i++) {
			if (status[i] == 0) {
				if (!dfs(graph, i, status, result)) {
					return new int[] {};
				}
			}
		}

		int[] res = new int[numCourses];
		for (int i = numCourses - 1; i >= 0; i--) {
			res[numCourses - i - 1] = result.get(i);
		}

		return res;
	}

	public boolean dfs(ArrayList<HashSet<Integer>> graph, int node, int[] status, List<Integer> result) {
		status[node] = 1;
		for (Integer nei : graph.get(node)) {
			if (status[nei] == 1) {
				return false;
			}
			if (status[nei] == 0) {
				if (!dfs(graph, nei, status, result)) {
					return false;
				}
			}
		}
		status[node] = 2;
		result.add(node);
		return true;
	}

}
