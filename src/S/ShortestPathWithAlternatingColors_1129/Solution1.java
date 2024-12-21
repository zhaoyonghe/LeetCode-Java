package S.ShortestPathWithAlternatingColors_1129;
/**
 * $$ Assume m is the number of edges.
 * $$ Time Complexity: O(n + m)
 * $$ Space Complexity: O(n + m)
 */

import java.util.*;

public class Solution1 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] distances = new int[n];
        Arrays.fill(distances, -1);
        boolean[][] visited = new boolean[n][2];

        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] edge : redEdges) {
            g.get(edge[0]).add(new int[]{edge[1], 0});
        }
        for (int[] edge : blueEdges) {
            g.get(edge[0]).add(new int[]{edge[1], 1});
        }

        // bfs
        int distance = 0;
        distances[0] = 0;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        q.offer(new int[]{0, 1});
        visited[0][0] = true;
        visited[0][1] = true;
        while (!q.isEmpty() && distance <= redEdges.length + blueEdges.length) {
            distance++;
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] cur = q.poll();
                for (int[] next : g.get(cur[0])) {
                    if (visited[next[0]][next[1]] || cur[1] + next[1] != 1) {
                        continue;
                    }
                    visited[next[0]][next[1]] = true;
                    q.offer(next);
                    distances[next[0]] = distances[next[0]] == -1 ? distance : distances[next[0]];
                }
            }
        }

        return distances;
    }
}