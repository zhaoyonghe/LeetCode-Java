package CourseScheduleI;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Time Complexity: O(|V| + |E|)
 * Space Complexity: O(max(|V|, |E|))
 * Runtime: 5ms
 * Rank: 94.33%
 */

public class Solution3 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build graph
        ArrayList<HashSet<Integer>> graph = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            graph.add(new HashSet<Integer>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // dfs, detect cycles
        int[] status = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (status[i] == 0) {
                if (!dfs(graph, i, status)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(ArrayList<HashSet<Integer>> graph, int node, int[] status) {
        status[node] = 1;
        for (Integer nei : graph.get(node)) {
            if (status[nei] == 1) {
                return false;
            }
            if (status[nei] == 0) {
                if (!dfs(graph, nei, status)) {
                    return false;
                }
            }
        }
        status[node] = 2;
        return true;
    }

}
