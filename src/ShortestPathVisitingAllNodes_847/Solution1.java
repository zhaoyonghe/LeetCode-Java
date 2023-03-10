package ShortestPathVisitingAllNodes_847;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Assume s.length() is n.
 * Time Complexity: O(n * 2 ^ n)
 * Space Complexity: O(n * 2 ^ n)
 * Runtime: 11ms
 * Rank: 83.03%
 */
public class Solution1 {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if (n <= 1) {
            return 0;
        }
        boolean[][] rec = new boolean[1 << n][n];
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            q.offer(new int[]{1 << i, i});
            rec[1 << i][i] = true;
        }
        int cnt = 1;
        // The input graph is always connected, so while will be exit.
        while (true) {
            int sz = q.size();
            for (int j = 0; j < sz; j++) {
                int[] cur = q.poll();
                int curState = cur[0];
                int curID = cur[1];
                for (int next: graph[curID]) {
                    // graph[i] does not contain i, so do not need to check self-edge:
                    // if (next == curID) {
                    //     continue;
                    // }
                    int nextState = cur[0] | (1 << next);
                    if (nextState == (1 << n) - 1) {
                        return cnt;
                    }
                    if (rec[nextState][next]) {
                        continue;
                    }
                    rec[nextState][next] = true;
                    q.offer(new int[]{nextState, next});
                }
            }
            cnt++;
        }
    }
}
