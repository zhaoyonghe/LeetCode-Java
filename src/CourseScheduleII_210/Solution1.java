package CourseScheduleII_210;

import java.util.*;

/**
 * $$ Assume numCourses is V, len(prerequisites) is E.
 * $$ Time Complexity: O(E + V)
 * $$ Space Complexity: O(E + V)
 */

public class Solution1 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // [0, 1] means 0 <- 1

        // Build graph.
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] e : prerequisites) {
            g.get(e[1]).add(e[0]);
        }
        int[] indegree = new int[numCourses];
        for (int[] e : prerequisites) {
            indegree[e[0]]++;
        }

        // Find nodes without indegree and put them into a queue.
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // While queue is not empty, take course queue.poll().
        // Put new nodes without indegree into the queue.
        List<Integer> seq = new ArrayList<>();
        while (!q.isEmpty()) {
            int from = q.poll();
            seq.add(from);
            g.get(from).forEach((to) -> {
                indegree[to]--;
                if (indegree[to] == 0) {
                    q.offer(to);
                }
            });
        }

        if (seq.size() < numCourses) {
            return new int[]{};
        }
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = seq.get(i);
        }
        return res;
    }
}
