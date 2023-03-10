package NetworkDelayTime;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Assume times.length is E.
 * Time Complexity: O((N + E)logN)
 * Space Complexity: O(N + E)
 * Runtime: 14ms
 * Rank: 59.76%
 */
public class Solution1 {
    public int networkDelayTime(int[][] times, int N, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((n1, n2) -> (n1[1] - n2[1]));

        int[][] dist = new int[N + 1][2];
        boolean[] done = new boolean[N + 1];

        // dist[nodeIndex]: [nodeIndex, distance from K]
        for (int i = 1; i <= N; i++) {
            dist[i][0] = i;
            dist[i][1] = Integer.MAX_VALUE;
        }
        dist[K][1] = 0;

        for (int i = 1; i <= N; i++) {
            queue.offer(dist[i]);
        }

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<int[]>());
        }
        for (int[] time : times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        while (queue.size() != 0) {
            int[] temp = queue.poll();
            int u = temp[0];
            if (done[u]) {
                continue;
            }
            done[u] = true;
            dist[u][1] = temp[1];
            queue.remove(dist[u]);

            List<int[]> nei = graph.get(u);
            for (int[] tem : nei) {
                int v = tem[0];
                int w = tem[1];
                if (!done[v] && dist[v][1] > dist[u][1] + w) {
                    dist[v][1] = dist[u][1] + w;
                    queue.remove(dist[v]);
                    queue.offer(dist[v]);
                }
            }
        }

        int max = -1;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dist[i][1]);
        }

        return max == Integer.MAX_VALUE ? -1 : max;
    }
}
