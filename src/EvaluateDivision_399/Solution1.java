package EvaluateDivision_399;

import java.util.*;
/**
 * Time Complexity: O(m * n)
 * Space Complexity: O(max(m, n))
 * Runtime: 1ms
 * Rank: 97.61%
 */
public class Solution1 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = values.length;
        Map<String, Map<String, Double>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];
            if (!g.containsKey(a)) {
                g.put(a, new HashMap<>());
            }
            if (!g.containsKey(b)) {
                g.put(b, new HashMap<>());
            }
            g.get(a).put(b, val);
            g.get(b).put(a, 1 / val);
        }
        int m = queries.size();
        double[] res = new double[m];
        for (int i = 0; i < m; i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (!g.containsKey(a) || !g.containsKey(b)) {
                res[i] = -1.0;
                continue;
            }
            Double ans = dfs(a, b, new HashSet<String>(), g);
            res[i] = ans == null ? -1.0 : ans;
        }
        return res;
    }

    private Double dfs(String cur, String target, Set<String> visited, Map<String, Map<String, Double>> g) {
        if (visited.contains(cur)) {
            return null;
        }
        visited.add(cur);
        if (cur.equals(target)) {
            return 1.0;
        }
        for (Map.Entry<String, Double> en: g.get(cur).entrySet()) {
            Double prev = dfs(en.getKey(), target, visited, g);
            if (prev == null) {
                continue;
            }
            return prev * en.getValue();
        }
        return null;
    }
}
