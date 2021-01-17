package NetworkDelayTime;

import java.util.Arrays;

/**
 * Assume times.length is E.
 * Time Complexity: O(N ^ 2 + E)
 * Space Complexity: O(N ^ 2)
 * Runtime: 3ms
 * Rank: 100.00%
 */
public class Solution3 {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[] dist = new int[N + 1];
        boolean[] done = new boolean[N + 1];

        Arrays.fill(dist, -1);
        dist[K] = 0;

        // adjacent matrix
        int[][] graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                graph[i][j] = -1;
            }
        }
        for (int[] time : times) {
            graph[time[0]][time[1]] = time[2];
            if (time[0] == K) {
                dist[time[1]] = time[2];
            }
        }

        done[K] = true;

        for (int j = 1; j < N; j++) {
            // find the lowest dist
            int u = -1;
            int minDist = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                if (!done[i] && dist[i] != -1 && minDist > dist[i]) {
                    u = i;
                    minDist = dist[i];
                }
            }

            if (u == -1) {
                // no reachable node from K can be extracted
                break;
            }

            done[u] = true;

            for (int v = 1; v <= N; v++) {
                int w = graph[u][v];
                if (w != -1 && !done[v] && (dist[v] == -1 || dist[v] > dist[u] + w)) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        int max = -1;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == -1) {
                return -1;
            }
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}
