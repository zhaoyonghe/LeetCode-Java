package BusRoutes_815;

import java.util.*;

/**
 * Time Complexity: O(sum(routes[i].length))
 * Space Complexity: O(sum(routes[i].length))
 * Runtime: 63ms
 * Rank: 66.57%
 */

public class Solution1 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        Map<Integer, List<Integer>> s2rt = new HashMap<>();
        List<Set<Integer>> g = new ArrayList<>();

        for (int i = 0; i < routes.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int stop : routes[i]) {
                s2rt.computeIfAbsent(stop, k -> new ArrayList<>());
                s2rt.get(stop).add(i);
                set.add(stop);
            }
            g.add(set);
        }

        boolean[] taken = new boolean[routes.length];
        Set<Integer> visited = new HashSet<>();
        int res = 1;

        Deque<Integer> q = new ArrayDeque<>();
        visited.add(source);
        q.offer(source);

        while (q.size() > 0) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int cur = q.poll();
                List<Integer> nextRoutes = s2rt.get(cur);
                for (int rt : nextRoutes) {
                    if (taken[rt]) {
                        continue;
                    }
                    taken[rt] = true;
                    for (int next : g.get(rt)) {
                        if (visited.contains(next)) {
                            continue;
                        }
                        if (next == target) {
                            return res;
                        }
                        visited.add(next);
                        q.offer(next);
                    }
                }
            }
            res++;
        }

        return -1;
    }
}