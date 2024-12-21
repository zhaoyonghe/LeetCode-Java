package N.NetworkDelayTime_743;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * $$ Assume times.length is E, n is V.
 * $$ Time Complexity: O(V + ElogE)
 * $$ Space Complexity: O(V + E)
 */
public class Solution1 {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] time : times) {
            g.get(time[0] - 1).add(new int[]{time[1] - 1, time[2]});
        }

        boolean[] settled = new boolean[n];
        int[] dist = new int[n];
        int res = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, k - 1});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int path = now[0];
            int cur = now[1];
            if (settled[cur]) {
                continue;
            }
            settled[cur] = true;
            res = Math.max(res, path);
            for (int[] edge : g.get(cur)) {
                int next = edge[0];
                int w = edge[1];
                if (settled[next]) {
                    continue;
                }
                if (dist[next] == 0 || path + w < dist[next]) {
                    dist[next] = path + w;
                    pq.offer(new int[]{path + w, next});
                }
            }
        }

        int visited = 0;
        for (boolean b : settled) {
            visited += b ? 1 : 0;
        }
        return visited == n ? res : -1;
    }
}
