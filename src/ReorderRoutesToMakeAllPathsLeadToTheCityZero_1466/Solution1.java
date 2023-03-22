package ReorderRoutesToMakeAllPathsLeadToTheCityZero_1466;

import java.util.*;
/**
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public int minReorder(int n, int[][] connections) {
        List<Set<Integer>> g = new ArrayList<>();
        List<Set<Integer>> rg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new HashSet<>());
            rg.add(new HashSet<>());
        }
        for (int[] conn : connections) {
            g.get(conn[0]).add(conn[1]);
            g.get(conn[1]).add(conn[0]);
            rg.get(conn[0]).add(conn[1]);
        }
        boolean[] visited = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        visited[0] = true;
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : g.get(cur)) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                if (rg.get(cur).contains(next)) {
                    count++;
                }
                q.offer(next);
            }
        }
        return count;
    }
}