package CourseScheduleI_207;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * $$ Assume numCourses is V, len(prerequisites) is E.
 * $$ Time Complexity: O(E + V)
 * $$ Space Complexity: O(E + V)
 */
public class Solution1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        int nodeRemoved = 0;
        while (!q.isEmpty()) {
            int from = q.poll();
            nodeRemoved++;
            g.get(from).forEach((to) -> {
                indegree[to]--;
                if (indegree[to] == 0) {
                    q.offer(to);
                }
            });
        }

        // return whether the graph is empty.
        return nodeRemoved == numCourses;
    }
}
