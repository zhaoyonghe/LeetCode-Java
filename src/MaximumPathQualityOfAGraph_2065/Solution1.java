package MaximumPathQualityOfAGraph_2065;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Assume n is values.length.
 * Assume e is edges.length.
 * Time Complexity: O(n ^ 2 * e)
 * Space Complexity: O(n ^ 2 * e)
 * Runtime: 1805ms
 * Rank: 5.14%
 */
public class Solution1 {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        Map<Integer, List<int[]>> g = new HashMap<>();
        for (int[] edge : edges) {
            if (!g.containsKey(edge[0])) {
                g.put(edge[0], new ArrayList<>());
            }
            if (!g.containsKey(edge[1])) {
                g.put(edge[1], new ArrayList<>());
            }
            g.get(edge[0]).add(new int[]{edge[1], edge[2]});
            g.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        return val(values, helper(0, maxTime, new int[values.length], values, g));
    }

    private int[] helper(int now, int time, int[] history, int[] values, Map<Integer, List<int[]>> g) {
        if (time < 0) {
            return null;
        }
        int maxVal = -1;
        int[] maxValCnts = null;
        history[now]++;
        if (g.containsKey(now)) {
            for (int[] nextEn : g.get(now)) {
                int next = nextEn[0];
                int t = nextEn[1];
                // 10 <= time_j, maxTime <= 100. so recursion will be no more than 10 levels.
                int[] cnts = helper(next, time - t, history, values, g);
                if (cnts == null) {
                    continue;
                }
                int vv = val(values, cnts, history);
                if (vv > maxVal) {
                    maxVal = vv;
                    maxValCnts = cnts;
                }
            }
        }
        if (now == 0 && maxValCnts == null) {
            maxValCnts = new int[values.length];
        }
        if (maxValCnts != null) {
            maxValCnts[now]++;
        }
        history[now]--;
        return maxValCnts;
    }

    private int val(int[] values, int[] cnts) {
        int sum = 0;
        for (int i = 0; i < cnts.length; i++) {
            if (cnts[i] == 0) {
                continue;
            }
            sum += values[i];
        }
        return sum;
    }

    private int val(int[] values, int[] cnts, int[] history) {
        int sum = 0;
        for (int i = 0; i < cnts.length; i++) {
            if (cnts[i] == 0 && history[i] == 0) {
                continue;
            }
            sum += values[i];
        }
        return sum;
    }
}