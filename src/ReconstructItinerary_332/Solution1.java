package ReconstructItinerary_332;

import java.util.*;
/**
 * Assume n is tickets.size().
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(n)
 * Runtime: 26ms
 * Rank: 5.98%
 */
public class Solution1 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> g = new HashMap<>();
        Map<String, Integer> ts = new HashMap<>();
        for (List<String> t: tickets) {
            String from = t.get(0);
            String to = t.get(1);
            g.computeIfAbsent(from,k->new ArrayList<String>()).add(to);
            ts.compute(from.concat(to),(k,v)->(v==null)?1:v+1);
        }
        for (List<String> li: g.values()) {
            Collections.sort(li);
        }
        List<String> res = new ArrayList<>();
        res.add("JFK");
        dfs("JFK",g,ts,res);
        return res;
    }

    private boolean dfs(String cur, Map<String, List<String>> g, Map<String, Integer> ts, List<String> res) {
        if (ts.isEmpty()) {
            return true;
        }
        List<String> nexts = g.get(cur);
        if (nexts == null) {
            return false;
        }
        for (String next: nexts) {
            String tkt = cur.concat(next);
            Integer count = ts.get(tkt);
            if (count == null) {
                continue;
            }
            ts.compute(tkt,(k,v)->(v==1)?null:v-1);
            res.add(next);
            if (dfs(next,g,ts,res)) {
                return true;
            }
            // Revert.
            res.remove(res.size()-1);
            ts.put(tkt, count);
        }
        return false;
    }
}
