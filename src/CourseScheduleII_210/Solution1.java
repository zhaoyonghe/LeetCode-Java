package CourseScheduleII_210;

import java.util.*;

/**
 * Time Complexity: O(max(numCourses, prerequisites.length))
 * Space Complexity: O(max(numCourses, prerequisites.length))
 * Runtime: 5ms
 * Rank: 87.77%
 */
public class Solution1 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] res = new int[numCourses];
        int j = 0;
        while (!q.isEmpty()) {
            int c = q.poll();
            res[j] = c;
            j++;
            for (int next: g.get(c)) {
                degree[next]--;
                if (degree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] != 0) {
                return new int[0];
            }
        }
        return res;
    }
}
