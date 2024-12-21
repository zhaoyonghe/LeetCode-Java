package G.GraphValidTree_261;

import java.util.*;

/**
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] edge : edges) {
            if (!g.containsKey(edge[0])) {
                g.put(edge[0], new ArrayList<>());
            }
            if (!g.containsKey(edge[1])) {
                g.put(edge[1], new ArrayList<>());
            }
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (!g.containsKey(cur)) {
                continue;
            }
            for (int next : g.get(cur)) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                q.offer(next);
            }
        }
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}
