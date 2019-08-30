package CourseScheduleI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Time Complexity: O(|V| + |E|)
 * Space Complexity: O(max(|V|, |E|))
 * Runtime: 12ms
 * Rank: 81.02%
 */

class Solution2 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
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

		// O(|E| + |V|)
		for (int i = 0; i < numCourses; i++) {
			if (!visited[i] && !dfs(graph, visited, visiting, i)) {
				return false;
			}
		}

		return true;
	}

	public boolean dfs(List<Integer>[] graph, boolean[] visited, Set<Integer> visiting, int i) {
		if (visiting.contains(i)) {
			// this graph contains cycle
			return false;
		}

		visiting.add(i);

		for (int j = 0; j < graph[i].size(); j++) {
			if (!visited[graph[i].get(j)] && !dfs(graph, visited, visiting, graph[i].get(j))) {
				return false;
			}
		}

		visited[i] = true;
		visiting.remove(i);

		return true;
	}
}
