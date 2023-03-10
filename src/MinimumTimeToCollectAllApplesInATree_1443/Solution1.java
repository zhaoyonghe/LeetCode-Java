package MinimumTimeToCollectAllApplesInATree_1443;

import java.util.*;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 73ms
 * Rank: 38.62%
 */

public class Solution1 {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> e = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            e.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            e.get(edges[i][0]).add(edges[i][1]);
            e.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int cur = q.poll();
            visited[cur] = true;
            List<Integer> nlist = new ArrayList<>();
            for (int next : e.get(cur)) {
                if (visited[next]) {
                    continue;
                }
                nlist.add(next);
                q.offer(next);
            }
            e.set(cur, nlist);
        }
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < e.size(); i++) {
            for (int next : e.get(i)) {
                List<Integer> list = tree.getOrDefault(i, new ArrayList<Integer>());
                list.add(next);
                tree.put(i, list);
            }
        }

        int[] info = compute(0, tree, hasApple);
        return info[1] * 2;
    }

    private int[] compute(int cur, Map<Integer, List<Integer>> tree, List<Boolean> has) {
        List<Integer> children = tree.get(cur);
        // The number of apples in the subtree with root cur.
        int appleCount = has.get(cur) ? 1 : 0;
        // The number of branches I need to travel to collect
        // all apples in the subtree with root cur.
        int branchCount = 0;
        if (children == null) {
            return new int[]{appleCount, 0};
        }

        for (int c : children) {
            int[] info = compute(c, tree, has);
            if (info[0] > 0) {
                appleCount += info[0];
                branchCount += info[1] + 1;
            }
        }

        return new int[]{appleCount, branchCount};
    }
}
