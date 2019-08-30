package CourseScheduleII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Time Complexity: O(|V| + |E|)
 * Space Complexity: O(max(|V|, |E|))
 * Runtime: 11ms
 * Rank: 84.03%
 */

class Solution2 {
	@SuppressWarnings("unchecked")
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		// initialize the adjacent list, O(|V|)
		ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		// construct the adjacent list, O(|E|)
		for (int[] edge : prerequisites) {
			graph[edge[1]].add(edge[0]);
		}

		boolean[] visited = new boolean[numCourses];

		Set<Integer> visiting = new HashSet<Integer>();

		int[] result = new int[numCourses];

		int[] index = new int[] { numCourses - 1 };

		for (int i = 0; i < numCourses; i++) {
			if (!visited[i] && !dfs(graph, visited, visiting, i, index, result)) {
				return new int[] {};
			}
		}

		return result;
	}

	public boolean dfs(List<Integer>[] graph, boolean[] visited, Set<Integer> visiting, int i, int[] index,
			int[] result) {
		if (visiting.contains(i)) {
			// this graph contains a cycle
			return false;
		}

		visiting.add(i);

		// explore adjacent vertices
		for (int j = 0; j < graph[i].size(); j++) {
			if (!visited[graph[i].get(j)] && !dfs(graph, visited, visiting, graph[i].get(j), index, result)) {
				return false;
			}
		}

		visited[i] = true;
		visiting.remove(i);

		result[index[0]] = i;
		index[0] -= 1;

		return true;
	}
}