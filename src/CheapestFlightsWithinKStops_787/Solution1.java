package CheapestFlightsWithinKStops_787;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(n ^ (K + 1))
 * Space Complexity: O(K + 1)
 * Runtime: 85ms
 * Rank: 19.37%
 */

public class Solution1 {
    public int cheap = Integer.MAX_VALUE;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        boolean[] visited = new boolean[n];

        ArrayList<HashMap<Integer, Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashMap<Integer, Integer>());
        }

        for (int i = 0; i < flights.length; i++) {
            graph.get(flights[i][0]).put(flights[i][1], flights[i][2]);
        }

        dfs(graph, src, dst, K + 1, 0, visited);

        return cheap == Integer.MAX_VALUE ? -1 : cheap;
    }

    public void dfs(ArrayList<HashMap<Integer, Integer>> graph, int src, int dst, int K, int cost, boolean[] visited) {
        if (K == 0) {
            return;
        }
        if (cost >= cheap) {
            return;
        }

        visited[src] = true;
        for (Map.Entry<Integer, Integer> entry : graph.get(src).entrySet()) {
            if (!visited[entry.getKey()]) {
                if (dst == entry.getKey()) {
                    cheap = Math.min(cheap, cost + entry.getValue());
                    continue;
                } else {
                    dfs(graph, entry.getKey(), dst, K - 1, cost + entry.getValue(), visited);
                }
            }
        }
        visited[src] = false;
    }
}
