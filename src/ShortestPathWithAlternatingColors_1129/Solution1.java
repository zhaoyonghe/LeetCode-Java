package ShortestPathWithAlternatingColors_1129;
/**
 * Assume m is the number of edges.
 * Time Complexity: O(n + m)
 * Space Complexity: O(n + m)
 * Runtime: 5ms
 * Rank: 87.37%
 */
import java.util.*;

public class Solution1 {
    public int[] shortestAlternatingPaths(int n, int[][] red, int[][] blue) {
        Map<Integer,List<Integer>> rg = convert(red);
        Map<Integer,List<Integer>> bg = convert(blue);
        boolean[] rv = new boolean[n];
        boolean[] bv = new boolean[n];
        rv[0] = true;
        bv[0] = true;
        Deque<Integer> rq = new ArrayDeque<>();
        Deque<Integer> bq = new ArrayDeque<>();
        rq.offer(0);
        bq.offer(0);
        int[] res = new int[n];
        Arrays.fill(res, -1);

        int step = 0;

        while (!rq.isEmpty() || !bq.isEmpty()) {
            visit(rq,bv,bg,step,res);
            visit(bq,rv,rg,step,res);
            Deque<Integer> tmp = rq;
            rq = bq;
            bq = tmp;
            step++;
        }
        return res;
    }

    private void visit(Deque<Integer> q, boolean[] visited, Map<Integer,List<Integer>> g, int step, int[] res) {
        if (q.isEmpty()) {
            return;
        }

        int size = q.size();

        for (int i = 0; i < size; i++) {
            int cur = q.poll();
            if (res[cur] == -1) {
                res[cur] = step;
            } else {
                res[cur] = Math.min(res[cur], step);
            }
            List<Integer> nexts = g.get(cur);
            if (nexts == null) {
                continue;
            }
            for (int next: nexts) {
                if (visited[next]) {
                    continue;
                }
                q.offer(next);
                visited[next] = true;
            }
        }
    }

    private Map<Integer, List<Integer>> convert(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Arrays.stream(edges).forEach(edge->{
            map.compute(edge[0], (k,v)->{
                if (v == null) {
                    v = new ArrayList<>();
                }
                v.add(edge[1]);
                return v;
            });
        });
        return map;
    }
}