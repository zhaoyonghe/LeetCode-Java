package CheapestFlightsWithinKStops_787;

import java.util.Arrays;

public class Solution2 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[src] = 0;

        for (int i = 0; i <= K; i++) {
            int[] temp = dist.clone();
            for (int j = 0; j < flights.length; j++) {
                int u = flights[j][0];
                int v = flights[j][1];
                int w = flights[j][2];

                if (temp[v] == -1 && dist[u] != -1) {
                    temp[v] = dist[u] + w;
                } else if (temp[v] != -1 && dist[u] != -1) {
                    if (temp[v] > dist[u] + w) {
                        temp[v] = dist[u] + w;
                    }
                }
            }
            dist = temp;
            // System.out.println(Arrays.toString(dist));
        }

        return (dist[dst] == Integer.MAX_VALUE) ? -1 : dist[dst];
    }
}
