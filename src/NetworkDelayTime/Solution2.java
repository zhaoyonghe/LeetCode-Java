package NetworkDelayTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Assume times.length is E.
 * Time Complexity: O(N ^ 2 + E)
 * Space Complexity: O(N + E)
 * Runtime: 9ms
 * Rank: 66.00%
 */
public class Solution2 {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[] dist = new int[N + 1];
        boolean[] done = new boolean[N + 1];

        Arrays.fill(dist, -1);
        dist[K] = 0;

        // adjacent list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<int[]>());
        }
        for (int[] time : times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]});
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

            List<int[]> nei = graph.get(u);
            for (int[] temp : nei) {
                int v = temp[0];
                int w = temp[1];
                if (!done[v] && (dist[v] == -1 || dist[v] > dist[u] + w)) {
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
