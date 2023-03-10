package CourseScheduleI_207;

import java.util.*;

/**
 * Time Complexity: O(max(numCourses, prerequisites.length))
 * Space Complexity: O(max(numCourses, prerequisites.length))
 * Runtime: 4ms
 * Rank: 89.41%
 */
public class Solution1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            g.add(new ArrayList<>());
        }
        int[] degree = new int[numCourses];
        for (int[] e: prerequisites) {
            degree[e[0]]++;
            g.get(e[1]).add(e[0]);
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            for (int next: g.get(q.poll())) {
                degree[next]--;
                if (degree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
