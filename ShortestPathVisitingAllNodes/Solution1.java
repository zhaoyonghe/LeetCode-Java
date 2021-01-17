package ShortestPathVisitingAllNodes;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Assume s.length() is n.
 * Time Complexity: O(n * 2 ^ n)
 * Space Complexity: O(n * 2 ^ n)
 * Runtime: 7ms
 * Rank: 100.00%
 */
public class Solution1 {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        int target = (1 << n) - 1;

        boolean[][] visited = new boolean[n][1 << n];

        Deque<int[]> queue = new ArrayDeque<>();
        int path = 0;
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1 << i});
            visited[i][1 << i] = true;
        }

        while (!queue.isEmpty()) {
            int sz = queue.size();
            while (sz != 0) {
                int[] temp = queue.poll();
                int cur = temp[0];
                int status = temp[1];

                if (status == target) {
                    return path;
                }

                for (int nei : graph[cur]) {
                    int nstatus = status | (1 << nei);
                    if (!visited[nei][nstatus]) {
                        queue.offer(new int[]{nei, nstatus});
                        visited[nei][nstatus] = true;
                    }
                }
                sz -= 1;
            }
            path += 1;
        }

        return -1;
    }
}
